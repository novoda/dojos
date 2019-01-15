package com.novoda.workshop.core

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.*

private const val HEADER_BASIC = "Basic "
private const val HEADER_ACCEPT = "Accept "
private const val AUTHORIZATION = "Authorization "
private const val HEADER_API_VERSION = "application/vnd.github.v3+json"

internal class NetworkDependencyProvider(private val userName: String, private val token: String) {

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                authInterceptor(chain)
            }.build()
    }

    private fun authInterceptor(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
            .header(HEADER_ACCEPT, HEADER_API_VERSION)
            .header(AUTHORIZATION, authTokenHeader())
        val request = builder.build()
        return chain.proceed(request)
    }

    private fun authTokenHeader(): String {
        return HEADER_BASIC + Base64.getEncoder().encode("$userName:$token".toByteArray()).toString(
            Charsets.UTF_8
        )
    }
}
