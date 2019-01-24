package com.novoda.workshop.contributors.fetcher

import com.novoda.workshop.contributors.data.Contributor

internal class ContributorsFetcher(private val backend: ContributorsBackend) {

    // TODO: Understand the problem
    // We iterate through all repositories of the novoda organisation, collect the contributors per repository and add them to one list.
    // Therefore we obviously have duplicated contributors which we need to aggregate.
    suspend fun fetchContributors(callback: (List<Contributor>) -> Unit) {
        val deferredRepos = backend.listRepos()
        val repos = deferredRepos.await()
        val allContributors = mutableListOf<Contributor>()

        repos.forEach { repo ->
            val users = backend.listContributors(repo.name).await()
            allContributors.addAll(users)
            callback.invoke(
                    allContributors
//                    .aggregate()
                    // TODO: Implement an extension on List<Contributors> which aggregates the contributions and remove the comment above to call it
                    // 1. Group the contributions by contributor name
                    // 2. Aggregate contributors by reducing each group
                    // 3. Sort the result by the number of contributions
                    //
                    // Useful links:
                    // - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/group-by.html
                    // - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flat-map.html
                    // - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reduce.html

            )
        }
    }
}

