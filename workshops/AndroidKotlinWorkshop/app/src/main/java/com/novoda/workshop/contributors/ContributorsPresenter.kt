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
            try {
                val deferredRepos = backend.listRepos()
                val repos = deferredRepos.await()
                val allContributors = mutableListOf<Contributor>()

                repos.forEach { repo ->
                    val users = backend.listContributors(repo.name).await()
                    allContributors.addAll(users)
                    view.render(allContributors.aggregate())
                }
            } catch (e: Exception) {
                view.showError(e.message)
            }
        }
    }

    fun stopPresenting() {
        job.cancel()
    }

    interface View {
        fun render(contributors: List<Contributor>)
        fun showError(message: String?)
    }

    private fun List<Contributor>.aggregate(): List<Contributor> =
        groupingBy { it.name }
            .reduce { login, a, b ->
                Contributor(login, a.contributions + b.contributions, a.avatarUrl)
            }
            .values
            .sortedByDescending { it.contributions }

}
