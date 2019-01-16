package com.novoda.workshop.contributors


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

    private fun List<Contributor>.aggregate(): List<Contributor> =
        groupingBy { it.name }
            .reduce { login, a, b ->
                Contributor(login, a.contributions + b.contributions, a.avatarUrl)
            }
            .values
            .sortedByDescending { it.contributions }

}
