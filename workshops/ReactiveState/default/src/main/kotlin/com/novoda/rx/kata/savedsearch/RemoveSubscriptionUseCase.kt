package com.novoda.rx.kata.savedsearch

import io.reactivex.Single
import java.util.*

interface RemoveSubscriptionUseCase {

    fun removeSubscriptionFor(savedSearch: SavedSearchesRepository.SavedSearch): Single<Result>

    sealed class Result {

        data class Success(val id: UUID = UUID.randomUUID()) : Result()
        data class Failed(val id: UUID = UUID.randomUUID()) : Result()

    }
}