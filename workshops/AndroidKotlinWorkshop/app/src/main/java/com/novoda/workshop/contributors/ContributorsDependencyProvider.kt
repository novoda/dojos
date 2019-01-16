package com.novoda.workshop.contributors

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.novoda.workshop.core.NetworkDependencyProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val GITHUB_API_URL = "https://api.github.com"

internal class ContributorsDependencyProvider(networkDependencyProvider: NetworkDependencyProvider) {
    private val httpClient = networkDependencyProvider.provideHttpClient()

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
