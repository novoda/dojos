package com.novoda.workshop.contributors

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ContributorsBackend {
    @GET("orgs/novoda/repos?per_page=100")
    fun listRepos(): Deferred<List<Repository>>

    @GET("repos/novoda/{repo}/contributors?per_page=100")
    fun listContributors(
        @Path("repo") repo: String
    ): Deferred<List<Contributor>>
}
