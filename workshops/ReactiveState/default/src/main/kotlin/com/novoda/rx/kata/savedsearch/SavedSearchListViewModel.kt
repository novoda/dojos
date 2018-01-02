package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.misc.SchedulingStrategy2
import com.novoda.rx.kata.savedsearch.SavedSearchModel.SavedSearchWithSubscription
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
        private val schedulingStrategy2: SchedulingStrategy2
) : SavedSearchModel {

    var listener: SavedSearchModel.Listener? = null
    private var state: State = State(emptyList())

    private var statePipeline = BehaviorSubject.create<State>()
    private var addSubscription = PublishSubject.create<AddSubscriptionCommand>()

    init {

        addSubscription
                .withLatestFrom(statePipeline, { addCommand, state -> addCommand to state })
                .flatMapSingle { (addCommand, state) ->
                    subscriptionRepository
                            .subscribeTo(addCommand.savedSearch, addCommand.interval)
                            .toSingleDefault(true)
                            .onErrorReturn { false }
                            .map {
                                it to state to addCommand.savedSearch
                            }
                            .compose(schedulingStrategy2.applyToSingle())
                }
                .doOnNext { (subscriptionResultToState, savedSearch) ->
                    if (subscriptionResultToState.first) {
                        listener?.onSubscriptionAddedTo(savedSearch)
                    } else {
                        listener?.onErrorAddingSubscriptionFor(savedSearch)
                    }
                }
                .map { (subscriptionResultToState, savedSearch) ->
                    val (subscriptionResult, state) = subscriptionResultToState
                    val result: MutableList<SavedSearchWithSubscription> = mutableListOf()
                    state.savedSearched.forEach {
                        if (it.savedSearch == savedSearch && subscriptionResult) {
                            result.add(SavedSearchWithSubscription(it.savedSearch, true))
                        } else {
                            result.add(it)
                        }
                    }
                    state.copy(savedSearched = result)
                }
                .subscribe(statePipeline)


        statePipeline.subscribeBy(onNext = { listener?.onStateLoaded(it.savedSearched) })
    }

    override fun subscribeTo(savedSearch: SavedSearch, interval: Interval) {
        addSubscription.onNext(AddSubscriptionCommand(savedSearch, interval))
    }

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
                                SavedSearchWithSubscription(savedSearch, true)
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

    private fun savedSearchWithoutSubscription(savedSearch: SavedSearch) =
            MaybeSource<SavedSearchWithSubscription> { p0 -> p0.onSuccess(SavedSearchWithSubscription(savedSearch, false)) }

    override fun unsubscribeFrom(savedSearch: SavedSearch) {
        subscriptionRepository
                .unSubscribeFrom(savedSearch)
                .doOnComplete {
                    val result: MutableList<SavedSearchWithSubscription> = mutableListOf()
                    state.savedSearched.forEach {
                        if (it.savedSearch == savedSearch) {
                            result.add(SavedSearchWithSubscription(it.savedSearch, false))
                        } else {
                            result.add(it)
                        }
                    }
                    state = state.copy(savedSearched = result)
                }
                .compose(schedulingStrategy2.applyToCompletable())
                .subscribeBy(
                        onComplete = { listener?.onSubscriptionRemovedFrom(savedSearch) },
                        onError = { listener?.onErrorRemovingSubscriptionFor(savedSearch) }
                )
    }

    private data class State(val savedSearched: List<SavedSearchWithSubscription>)
    private data class AddSubscriptionCommand(val savedSearch: SavedSearch, val interval: Interval)
}
