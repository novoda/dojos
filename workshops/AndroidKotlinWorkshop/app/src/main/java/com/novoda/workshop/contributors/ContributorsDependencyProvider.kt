package com.novoda.workshop.contributors

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.novoda.workshop.contributors.fetcher.ContributorsBackend
import com.novoda.workshop.contributors.fetcher.ContributorsFetcher
import com.novoda.workshop.contributors.fetcher.NetworkDependencyProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val GITHUB_API_URL = "https://api.github.com"

internal class ContributorsDependencyProvider(userName: String, token: String) {

    private val httpClient = NetworkDependencyProvider(userName, token).provideHttpClient()

    private fun provideBackend(): ContributorsBackend {
        val retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_API_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(ContributorsBackend::class.java)
    }

    fun providePresenter(): ContributorsPresenter {
        return ContributorsPresenter(provideFetcher())
    }

    private fun provideFetcher() = ContributorsFetcher(provideBackend())
}
