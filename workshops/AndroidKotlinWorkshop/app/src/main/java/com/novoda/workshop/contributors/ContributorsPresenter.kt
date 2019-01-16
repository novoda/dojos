package com.novoda.workshop.contributors

import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.fetcher.ContributorsFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal class ContributorsPresenter(private val fetcher: ContributorsFetcher) : CoroutineScope {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    private lateinit var job: Job

    fun startPresenting(view: View) {
        job = Job()

        launch {
            try {
                fetcher.fetchContributors { contributors ->
                    view.render(contributors)
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

}
