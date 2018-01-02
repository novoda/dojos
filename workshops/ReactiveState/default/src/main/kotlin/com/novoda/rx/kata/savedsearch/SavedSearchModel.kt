package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval

interface SavedSearchModel {

    fun loadSavedSearches()
    fun subscribeTo(savedSearch: SavedSearch, interval: Interval)
    fun unsubscribeFrom(savedSearch: SavedSearch)

    enum class Error {
        ADD,
        REMOVE
    }

    interface Listener {
        fun onStateLoaded(savedSearches: Map<SavedSearch, Boolean>, error: Error? = null)
    }
}
