package com.novoda.rx.kata


import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.novoda.rx.kata.misc.SchedulingStrategy2
import com.novoda.rx.kata.savedsearch.*
import com.novoda.rx.kata.savedsearch.SavedSearchModel.Error
import com.novoda.rx.kata.savedsearch.SavedSearchesRepository.SavedSearch
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Interval
import com.novoda.rx.kata.savedsearch.SubscriptionRepository.Subscription
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SavedSearchListViewModelTest {

    @Mock
    private lateinit var savedSearchesRepository: SavedSearchesRepository
    @Mock
    private lateinit var subscriptionRepository: SubscriptionRepository
    @Mock
    private lateinit var addSubscriptionUseCase: AddSubscriptionUseCase
    @Mock
    private lateinit var removeSubscriptionUseCase: RemoveSubscriptionUseCase

    private val subject by lazy {
        SavedSearchListViewModel(
                savedSearchesRepository,
                subscriptionRepository,
                addSubscriptionUseCase,
                removeSubscriptionUseCase,
                SchedulingStrategy2.immediate()
        )
    }


    @Test
    fun `should load saved searches with subscriptions`() {
        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)

        subject.loadSavedSearches()

        subject
                .state()
                .test()
                .assertValue(SavedSearchListViewModel.State(mapOf(savedSearch to false,
                        savedSearchWithSubscription to true)))
    }

    @Test
    fun `should not emit state twice when already done`() {
        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)

        subject.loadSavedSearches()
        subject.loadSavedSearches()

        subject
                .state()
                .test()
                .assertValueCount(1)
        verify(savedSearchesRepository, times(1)).listSavedSearches()
    }

    @Test
    fun `should subscribe to search`() {
        whenever(addSubscriptionUseCase.addSubscriptionFor(any(), any())).thenReturn(Single.just(AddSubscriptionUseCase.Result.Success()))

        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)
        subject.loadSavedSearches()

        subject.subscribeTo(savedSearch, Interval.NEW_RESULT)

        subject
                .state()
                .test()
                .assertValue(SavedSearchListViewModel.State(mapOf(savedSearch to true,
                        savedSearchWithSubscription to true)))
    }

    @Test
    fun `should notify with error in case adding a subscription failed`() {
        whenever(addSubscriptionUseCase.addSubscriptionFor(any(), any())).thenReturn(Single.just(AddSubscriptionUseCase.Result.Failed()))
        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)
        subject.loadSavedSearches()

        subject.subscribeTo(savedSearch, Interval.NEW_RESULT)

        subject
                .state()
                .test()
                .assertValue(SavedSearchListViewModel.State(mapOf(savedSearch to false,
                        savedSearchWithSubscription to true), Error.ADD))
    }

    @Test
    fun `should unsubscribe from search`() {
        whenever(removeSubscriptionUseCase.removeSubscriptionFor(any())).thenReturn(Single.just(RemoveSubscriptionUseCase.Result.Success()))
        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)
        subject.loadSavedSearches()

        subject.unsubscribeFrom(savedSearchWithSubscription)

        subject
                .state()
                .test()
                .assertValue(SavedSearchListViewModel.State(mapOf(savedSearch to false,
                        savedSearchWithSubscription to false)))
    }

    @Test
    fun `should notify with error in case removing a subscription failed`() {
        whenever(removeSubscriptionUseCase.removeSubscriptionFor(any())).thenReturn(Single.just(RemoveSubscriptionUseCase.Result.Failed()))
        val savedSearch = savedSearch(id = 1, searchId = 1)
        val savedSearchWithSubscription = savedSearch(id = 2, searchId = 2)
        givenSavedSearches(listOf(savedSearch, savedSearchWithSubscription))
        givenSavedSearchHasNoSubscription(savedSearch)
        givenSavedSearchHasSubscription(savedSearchWithSubscription)
        subject.loadSavedSearches()

        subject.unsubscribeFrom(savedSearchWithSubscription)

        subject
                .state()
                .test()
                .assertValue(SavedSearchListViewModel.State(mapOf(savedSearch to false,
                        savedSearchWithSubscription to true), Error.REMOVE))
    }

    private fun givenSavedSearchHasSubscription(savedSearch: SavedSearch) {
        whenever(subscriptionRepository.hasSubscriptionFor(savedSearch)).thenReturn(Maybe.just(Subscription(savedSearch.id, Interval.ONCE_A_DAY)))
    }

    private fun givenSavedSearchHasNoSubscription(savedSearch: SavedSearch) {
        whenever(subscriptionRepository.hasSubscriptionFor(savedSearch)).thenReturn(Maybe.empty())
    }

    private fun savedSearch(id: Long, searchId: Long) = SavedSearch(id = id, searchId = searchId, label = "savedSearch")

    private fun givenSavedSearches(listOf: List<SavedSearch>) {
        whenever(savedSearchesRepository.listSavedSearches()).thenReturn(Observable.just(listOf))
    }
}
