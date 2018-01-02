package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.search.Search
import io.reactivex.Maybe
import io.reactivex.Observable

interface SavedSearchesRepository {

    fun listSavedSearches(): Observable<List<SavedSearch>>

    fun hasSavedSearchFor(search: Search): Maybe<SavedSearch>

    data class SavedSearch(val id: Long, val searchId: Long, val label: String)
}
