package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.misc.SchedulingStrategy2
import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval
import io.reactivex.MaybeSource
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.withLatestFrom
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class SavedSearchListViewModel(
        private val savedSearchesRepository: SavedSearchesRepository,
        private val subscriptionRepository: SubscriptionRepository,
        private val addSubscriptionUseCase: AddSubscriptionUseCase,
        private val removeSubscriptionUseCase: RemoveSubscriptionUseCase,
        private val schedulingStrategy2: SchedulingStrategy2
) : SavedSearchModel {

    var listener: SavedSearchModel.Listener? = null
    private var state: State = State(emptyMap())

    private var statePipeline = BehaviorSubject.create<State>()
    private var addSubscription = PublishSubject.create<AddSubscriptionCommand>()
    private var removeSubscription = PublishSubject.create<RemoveSubscriptionCommand>()

    init {

        addSubscription
                .withLatestFrom(statePipeline, { addCommand, state -> addCommand to state })
                .flatMapSingle { (addCommand, state) ->
                    addSubscriptionUseCase
                            .addSubscriptionFor(addCommand.savedSearch, addCommand.interval)
                            .map {
                                it to state to addCommand.savedSearch
                            }
                            .compose(schedulingStrategy2.applyToSingle())
                }
                .map { (subscriptionResultToState, savedSearch) ->
                    val (subscriptionResult, state) = subscriptionResultToState
                    val savedSearches = mutableMapOf<SavedSearch, Boolean>()
                    savedSearches.putAll(state.savedSearched)
                    val subscriptionAdded = subscriptionResult is AddSubscriptionUseCase.Result.Success
                    savedSearches.put(savedSearch, subscriptionAdded)
                    val error = if (!subscriptionAdded) SavedSearchModel.Error.ADD else null
                    state.copy(savedSearched = savedSearches, error = error)
                }
                .subscribe(statePipeline)


        removeSubscription
                .withLatestFrom(statePipeline, { removeCommand, state -> removeCommand to state })
                .flatMapSingle { (removeCommand, state) ->
                    removeSubscriptionUseCase
                            .removeSubscriptionFor(removeCommand.savedSearch)
                            .map {
                                it to state to removeCommand.savedSearch
                            }
                            .compose(schedulingStrategy2.applyToSingle())
                }
                .map { (subscriptionResultToState, savedSearch) ->
                    val (subscriptionResult, state) = subscriptionResultToState
                    val savedSearches = mutableMapOf<SavedSearch, Boolean>()
                    savedSearches.putAll(state.savedSearched)
                    val subscriptionRemoved = subscriptionResult is RemoveSubscriptionUseCase.Result.Success
                    savedSearches.put(savedSearch, subscriptionRemoved.not())
                    val error = if (!subscriptionRemoved) SavedSearchModel.Error.REMOVE else null
                    state.copy(savedSearched = savedSearches, error = error)
                }
                .subscribe(statePipeline)



        statePipeline.subscribeBy(onNext = { listener?.onStateLoaded(it.savedSearched, it.error) })
    }

    private fun savedSearchWithoutSubscription(savedSearch: SavedSearch) =
            MaybeSource<Pair<SavedSearch, Boolean>> { p0 -> p0.onSuccess(savedSearch to false) }

    override fun loadSavedSearches() {
        if (state.savedSearched.isNotEmpty()) {
            listener?.onStateLoaded(state.savedSearched)
            return
        }

        savedSearchesRepository
                .listSavedSearches()
                .flatMap { savedSearch ->
                    Observable.fromIterable(savedSearch)
                }
                .flatMapSingle { savedSearch ->
                    subscriptionRepository
                            .hasSubscriptionFor(savedSearch)
                            .map {
                                savedSearch to true
                            }.switchIfEmpty(
                            savedSearchWithoutSubscription(savedSearch)
                    ).toSingle()
                }
                .map {
                    state.copy(savedSearched = state.savedSearched.plus(it))
                }
                .doOnNext {
                    state = it
                }
                .compose(schedulingStrategy2.apply())
                .subscribeBy(
                        onNext = {
                            statePipeline.onNext(it)

                        }
                )
    }

    override fun subscribeTo(savedSearch: SavedSearch, interval: Interval) {
        addSubscription.onNext(AddSubscriptionCommand(savedSearch, interval))
    }

    override fun unsubscribeFrom(savedSearch: SavedSearch) {
        removeSubscription.onNext(RemoveSubscriptionCommand(savedSearch))
    }

    private data class State(val savedSearched: Map<SavedSearch, Boolean>, val error: SavedSearchModel.Error? = null)
    private data class AddSubscriptionCommand(val savedSearch: SavedSearch, val interval: Interval)
    private data class RemoveSubscriptionCommand(val savedSearch: SavedSearch)
}
