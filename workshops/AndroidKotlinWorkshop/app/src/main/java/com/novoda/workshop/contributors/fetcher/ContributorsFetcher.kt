package com.novoda.workshop.contributors.fetcher

import com.novoda.workshop.contributors.data.Contributor

internal class ContributorsFetcher(private val backend: ContributorsBackend) {
    suspend fun fetchContributors(callback: (List<Contributor>) -> Unit) {
        val deferredRepos = backend.listRepos()
        val repos = deferredRepos.await()
        val allContributors = mutableListOf<Contributor>()

        repos.forEach { repo ->
            val users = backend.listContributors(repo.name).await()
            allContributors.addAll(users)
            callback.invoke(allContributors.aggregate())
        }
    }
}
