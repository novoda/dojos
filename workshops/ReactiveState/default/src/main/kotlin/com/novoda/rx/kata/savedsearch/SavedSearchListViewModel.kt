package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.misc.SchedulingStrategy2
import com.novoda.rx.kata.savedsearch.SavedSearchModel.SavedSearchWithSubscription
import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval
import io.reactivex.MaybeSource
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject

class SavedSearchListViewModel(
        private val savedSearchesRepository: SavedSearchesRepository,
        private val subscriptionRepository: SubscriptionRepository,
        private val schedulingStrategy2: SchedulingStrategy2
) : SavedSearchModel {

    var listener: SavedSearchModel.Listener? = null
    private var state: State = State(emptyList())

    private var statePipeline = BehaviorSubject.create<State>()

    init {
        statePipeline
                .subscribeBy(
                        onNext = { listener?.onStateLoaded(it.savedSearched) }
                )
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

    override fun subscribeTo(savedSearch: SavedSearch, interval: Interval) {
        subscriptionRepository
                .subscribeTo(savedSearch, interval)
                .doOnComplete {
                    val result: MutableList<SavedSearchWithSubscription> = mutableListOf()
                    state.savedSearched.forEach {
                        if (it.savedSearch == savedSearch) {
                            result.add(SavedSearchWithSubscription(it.savedSearch, true))
                        } else {
                            result.add(it)
                        }
                    }
                    state = state.copy(savedSearched = result)
                }
                .compose(schedulingStrategy2.applyToCompletable())
                .subscribeBy(
                        onComplete = { listener?.onSubscriptionAddedTo(savedSearch) },
                        onError = { listener?.onErrorAddingSubscriptionFor(savedSearch) }
                )
    }

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
}
