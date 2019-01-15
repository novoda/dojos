package com.novoda.workshop.contributors

import com.novoda.workshop.Repo
import com.novoda.workshop.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ContributorsBackend {
    @GET("orgs/{org}/repos?per_page=100")
    fun listOrgRepos(
        @Path("org") org: String
    ): Deferred<List<Repo>>

    @GET("repos/{owner}/{repo}/contributors?per_page=100")
    fun listRepoContributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Deferred<List<User>>
}
