package com.novoda.workshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_contributers.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import kotlin.coroutines.CoroutineContext

class ContributorsActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributers)
    }

    override fun onStart() {
        super.onStart()
        job = Job()

        val service = createService()

        launch {
            val deferredRepos = service.listOrgRepos("novoda")
            val repos = deferredRepos.await()
            label.text = repos.size.toString()
        }

    }

    private fun createService(): GitHubService {
        val userName = "XXX"
        val token = "XXX"
        val authToken =
            "Basic " + Base64.getEncoder().encode("$userName:$token".toByteArray()).toString(
                Charsets.UTF_8
            )
        val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("Authorization", authToken)
                val request = builder.build()
                chain.proceed(request)
            }.build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(GitHubService::class.java)
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
    }
}
