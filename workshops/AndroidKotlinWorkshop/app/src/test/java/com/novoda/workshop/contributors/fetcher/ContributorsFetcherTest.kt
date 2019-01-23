package com.novoda.workshop.contributors.fetcher

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class ContributorsFetcherTest {
    private val backend: ContributorsBackend = mock()
    private val fetcher = ContributorsFetcher(backend)

    @Test
    fun `fetches contributors from one repo`() = runBlocking {
        val dojos = Repository(id = 1, name = "dojos")
        givenRepositories(dojos)
        givenContributions(dojos,
                contributor("berta", 1),
                contributor("michal", 1)
        )
        val callback = mock<(List<Contributor>) -> Unit>()
        fetcher.fetchContributors(callback)

        verify(callback).invoke(listOf(
                contributor("berta", 1),
                contributor("michal", 1)
        ))
    }

    @Test
    fun `fetches aggregated contributors from all repos and updates per repo`() = runBlocking {
        val dojos = Repository(id = 1, name = "dojos")
        val spikes = Repository(id = 2, name = "spikes")
        givenRepositories(dojos, spikes)
        givenContributions(dojos,
                contributor("berta", 1),
                contributor("michal", 1)
        )
        givenContributions(spikes,
                contributor("michal", 1)
        )
        val callback = mock<(List<Contributor>) -> Unit>()
        fetcher.fetchContributors(callback)

        verify(callback).invoke(listOf(
                contributor("berta", 1),
                contributor("michal", 1)
        ))
        verify(callback).invoke(listOf(
                contributor("michal", 2),
                contributor("berta", 1)
        ))
    }

    private fun contributor(name: String, contributions: Int): Contributor {
        return Contributor(name = name, contributions = contributions, avatarUrl = "some url")
    }

    private fun CoroutineScope.givenRepositories(vararg repositories: Repository) {
        whenever(backend.listRepos()).thenReturn(async { repositories.toList() })
    }

    private fun CoroutineScope.givenContributions(repository: Repository, vararg contributions: Contributor) {
        whenever(backend.listContributors(repository.name)).thenReturn(async { contributions.asList() })
    }
}
