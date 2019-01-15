package com.novoda.workshop.contributors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


internal class ContributorsPresenter(private val backend: ContributorsBackend) : CoroutineScope {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    private lateinit var job: Job

    fun startPresenting(view: View) {
        job = Job()

        launch {
            val deferredRepos = backend.listOrgRepos("novoda")
            val repos = deferredRepos.await()
            val repoSizeAsString = repos.size.toString()
            view.render(repoSizeAsString)
        }
    }

    fun stopPresenting() {
        job.cancel()
    }

    interface View {
        fun render(repoSizeAsString: String)
    }
}
