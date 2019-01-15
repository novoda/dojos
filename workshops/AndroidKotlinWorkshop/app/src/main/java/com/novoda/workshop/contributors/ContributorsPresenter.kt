package com.novoda.workshop.contributors

import com.novoda.workshop.User
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
            val deferredRepos = backend.listRepos()
            val repos = deferredRepos.await()
            val contributors = repos.flatMap { repo ->
                val users = backend.listContributors(repo.name).await()
                users
            }.aggregate()

            view.render(contributors)
        }
    }

    fun stopPresenting() {
        job.cancel()
    }

    interface View {
        fun render(contributors: List<User>)
    }

    private fun List<User>.aggregate(): List<User> =
        groupingBy { it.login }
            .reduce { login, a, b ->
                User(login, a.contributions + b.contributions)
            }
            .values
            .sortedByDescending { it.contributions }

}
