package com.novoda.workshop.contributors.fetcher

import okhttp3.OkHttpClient
import java.util.*

private const val HEADER_ACCEPT = "Accept"
private const val HEADER_API_VERSION = "application/vnd.github.v3+json"
private const val AUTHORIZATION = "Authorization"
private const val HEADER_BASIC = "Basic "

internal class NetworkDependencyProvider(private val userName: String, private val token: String) {

    // TODO add a request interceptor so each request to the Github API is authenticated
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    private fun authTokenHeader(): String {
        return HEADER_BASIC + Base64.getEncoder().encode("$userName:$token".toByteArray()).toString(
            Charsets.UTF_8
        )
    }
}
