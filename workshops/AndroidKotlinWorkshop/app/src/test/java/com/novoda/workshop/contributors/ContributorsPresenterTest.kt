package com.novoda.workshop.contributors

import com.nhaarman.mockitokotlin2.*
import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.fetcher.ContributorsFetcher
import com.novoda.workshop.contributors.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

@ExperimentalCoroutinesApi
class ContributorsPresenterTest {
    private val view: View = mock()
    private val fetcher: ContributorsFetcher = mock()
    private val presenter = ContributorsPresenter(
            fetcher,
            DispatcherStrategy(ui = Dispatchers.Unconfined, work = Dispatchers.Unconfined)
    )

    @Test
    fun `renders contributors`() = runBlocking {
        presenter.startPresenting(view)
        val contributions = listOf(aContributor("berta"), aContributor("michal"))

        capturedFetcherCallback().invoke(contributions)

        verify(view).render(contributions)
    }

    @Test
    fun `renders all fetched contributions`() = runBlocking {
        presenter.startPresenting(view)
        val firstContributions = listOf(aContributor("berta"), aContributor("michal"))
        val secondContributions = listOf(aContributor("berta"), aContributor("michal"), aContributor("alex"))
        val capturedFetcherCallback = capturedFetcherCallback()

        capturedFetcherCallback.invoke(firstContributions)
        capturedFetcherCallback.invoke(secondContributions)

        verify(view).render(firstContributions)
        verify(view).render(secondContributions)
    }

    @Test
    fun `shows error when fetching contributors fails`() = runBlocking {
        whenever(fetcher.fetchContributors(any())).thenThrow(IllegalStateException("something went wrong"))

        presenter.startPresenting(view)

        verify(view).showError("something went wrong")
    }

    private suspend fun capturedFetcherCallback(): (List<Contributor>) -> Unit {
        val capturedFetcherCallback = argumentCaptor<(List<Contributor>) -> Unit>()
        verify(fetcher).fetchContributors(capturedFetcherCallback.capture())
        return capturedFetcherCallback.firstValue
    }

    private fun aContributor(name: String): Contributor {
        return Contributor(name, 1, "")
    }
}
