package com.novoda.workshop.contributors

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.novoda.workshop.core.NetworkDependencyProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.github.com"
internal class ContributorsDependencyProvider(networkDependencyProvider: NetworkDependencyProvider) {
    private val httpClient = networkDependencyProvider.provideHttpClient()

    fun providerBackend(): ContributorsBackend {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(ContributorsBackend::class.java)
    }
}
