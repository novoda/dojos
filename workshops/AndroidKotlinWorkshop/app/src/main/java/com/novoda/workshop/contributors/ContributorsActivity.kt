package com.novoda.workshop.contributors

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.novoda.workshop.R
import com.novoda.workshop.core.NetworkDependencyProvider
import kotlinx.android.synthetic.main.activity_contributers.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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

    private fun createService(): ContributorsBackend {
        val userName = "XXX"
        val token = "XXX"
        val networkDependencyProvider = NetworkDependencyProvider(userName, token)
        return ContributorsDependencyProvider(networkDependencyProvider).providerBackend()
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
    }
}
