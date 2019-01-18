package com.novoda.workshop.contributors

import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.fetcher.ContributorsFetcher
import com.novoda.workshop.contributors.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

internal class ContributorsPresenter(
    private val fetcher: ContributorsFetcher,
    private val dispatcherStrategy: DispatcherStrategy = DispatcherStrategy(
        Dispatchers.Main,
        Dispatchers.IO
    )
) : CoroutineScope {

    override val coroutineContext: CoroutineContext get() = dispatcherStrategy.work + job

    private lateinit var job: Job
    private lateinit var view: View

    fun startPresenting(view: View) {
        job = Job()
        this.view = view

        launch {
            try {
                fetcher.fetchContributors { contributors ->
                    renderContributors(contributors)
                }
            } catch (e: Exception) {
                if (e.isNotCausedByCancellingJob()) {
                    showError(e)
                }
            }
        }
    }

    private fun renderContributors(contributors: List<Contributor>) = launch(dispatcherStrategy.ui) {
        view.render(contributors)
    }

    private fun showError(e: java.lang.Exception) = launch(dispatcherStrategy.ui) {
        view.showError(e.message)
    }

    fun stopPresenting() {
        job.cancel()
    }

}

private fun java.lang.Exception.isNotCausedByCancellingJob(): Boolean = this !is CancellationException
