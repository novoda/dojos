package com.novoda.rx.kata.savedsearch

import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval
import io.reactivex.Single
import java.util.*

interface AddSubscriptionUseCase {

    fun addSubscriptionFor(savedSearch: SavedSearch, interval: Interval): Single<Result>

    sealed class Result {

        data class Success(val id: UUID = UUID.randomUUID()) : Result()
        data class Failed(val id: UUID = UUID.randomUUID()) : Result()

    }
}