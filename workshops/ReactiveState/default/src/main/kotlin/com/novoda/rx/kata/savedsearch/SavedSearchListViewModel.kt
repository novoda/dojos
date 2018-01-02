package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.misc.SchedulingStrategy2
import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval
import io.reactivex.MaybeSource
import io.reactivex.Observable
import io.reactivex.functions.Consumer
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

    private var statePipeline = BehaviorSubject.create<State>()
    private var addSubscription = PublishSubject.create<AddSubscriptionCommand>()
    private var removeSubscription = PublishSubject.create<RemoveSubscriptionCommand>()

    init {

        Observable
                .merge(addSubscription(), removeSubscription())
                .subscribe(statePipeline)
    }

    private fun removeSubscription(): Observable<State> {
        return removeSubscription
                .withLatestFrom(statePipeline, { removeCommand, state -> removeCommand to state })
                .flatMapSingle { (removeCommand, state) ->
                    removeSubscriptionUseCase
                            .removeSubscriptionFor(removeCommand.savedSearch)
                            .map { result ->
                                result to state to removeCommand.savedSearch
                            }
                            .compose(schedulingStrategy2.applyToSingle())
                }
                .map { (subscriptionResultToState, savedSearch) ->
                    val (subscriptionResult, state) = subscriptionResultToState
                    val subscriptionRemoved = subscriptionResult is RemoveSubscriptionUseCase.Result.Success

                    val savedSearches = applyChange(state, savedSearch, isSubscribed = subscriptionRemoved.not())

                    val error = if (!subscriptionRemoved) SavedSearchModel.Error.REMOVE else null
                    state.copy(savedSearched = savedSearches, error = error)
                }
    }

    private fun applyChange(state: State, savedSearch: SavedSearch, isSubscribed: Boolean): MutableMap<SavedSearch, Boolean> {
        val savedSearches = mutableMapOf<SavedSearch, Boolean>()
        savedSearches.putAll(state.savedSearched)
        savedSearches.put(savedSearch, isSubscribed)
        return savedSearches
    }

    private fun addSubscription(): Observable<State> {
        return addSubscription
                .withLatestFrom(statePipeline, { addCommand, state -> addCommand to state })
                .flatMapSingle { (addCommand, state) ->
                    addSubscriptionUseCase
                            .addSubscriptionFor(addCommand.savedSearch, addCommand.interval)
                            .map { result ->
                                result to state to addCommand.savedSearch
                            }
                            .compose(schedulingStrategy2.applyToSingle())
                }
                .map { (subscriptionResultToState, savedSearch) ->
                    val (subscriptionResult, state) = subscriptionResultToState
                    val subscriptionAdded = subscriptionResult is AddSubscriptionUseCase.Result.Success

                    val savedSearches = applyChange(state, savedSearch, isSubscribed = subscriptionAdded)

                    val error = if (!subscriptionAdded) SavedSearchModel.Error.ADD else null
                    state.copy(savedSearched = savedSearches, error = error)
                }
    }

    override fun state(): Observable<State> = statePipeline

    private fun savedSearchWithoutSubscription(savedSearch: SavedSearch) =
            MaybeSource<Pair<SavedSearch, Boolean>> { p0 -> p0.onSuccess(savedSearch to false) }

    override fun loadSavedSearches() {
        if (statePipeline.hasValue()) {
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
                .toList()
                .map { savedSearchesAndSubcriptionState ->
                    val data: MutableMap<SavedSearch, Boolean> = mutableMapOf()
                    savedSearchesAndSubcriptionState.forEach {
                        val (savedSearch, isSubscribed) = it
                        data.put(savedSearch, isSubscribed)
                    }

                    State(data)
                }
                .compose(schedulingStrategy2.applyToSingle())
                .subscribe(Consumer {
                    statePipeline.onNext(it)
                })
    }

    override fun subscribeTo(savedSearch: SavedSearch, interval: Interval) {
        addSubscription.onNext(AddSubscriptionCommand(savedSearch, interval))
    }

    override fun unsubscribeFrom(savedSearch: SavedSearch) {
        removeSubscription.onNext(RemoveSubscriptionCommand(savedSearch))
    }

    data class State(val savedSearched: Map<SavedSearch, Boolean>, val error: SavedSearchModel.Error? = null)
    private data class AddSubscriptionCommand(val savedSearch: SavedSearch, val interval: Interval)
    private data class RemoveSubscriptionCommand(val savedSearch: SavedSearch)
}
