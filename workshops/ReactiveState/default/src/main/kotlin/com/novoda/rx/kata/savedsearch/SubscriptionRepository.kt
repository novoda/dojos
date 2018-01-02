package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import io.reactivex.Completable
import io.reactivex.Maybe

interface SubscriptionRepository {

    fun hasSubscriptionFor(savedSearch: SavedSearch): Maybe<Subscription>

    fun subscribeTo(savedSearch: SavedSearch, interval: Interval): Completable

    fun unSubscribeFrom(savedSearch: SavedSearch): Completable

    data class Subscription(val savedSearchId: Long, val interval: Interval)

    enum class Interval {
        NEW_RESULT,
        ONCE_A_DAY
    }
}
