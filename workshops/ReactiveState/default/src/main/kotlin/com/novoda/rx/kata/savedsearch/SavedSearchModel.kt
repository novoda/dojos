package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval

interface SavedSearchModel {

    fun loadSavedSearches()
    fun subscribeTo(savedSearch: SavedSearch, interval: Interval)
    fun unsubscribeFrom(savedSearch: SavedSearch)

    interface Listener {
        fun onStateLoaded(savedSearches: Map<SavedSearch, Boolean>)
        fun onSubscriptionAddedTo(savedSearch: SavedSearch)
        fun onErrorAddingSubscriptionFor(savedSearch: SavedSearch)
        fun onSubscriptionRemovedFrom(savedSearch: SavedSearch)
        fun onErrorRemovingSubscriptionFor(savedSearch: SavedSearch)
    }
}
