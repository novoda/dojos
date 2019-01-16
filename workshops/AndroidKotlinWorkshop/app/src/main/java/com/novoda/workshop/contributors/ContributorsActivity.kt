package com.novoda.workshop.contributors

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.novoda.workshop.R
import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.view.ContributorsAdapter
import com.novoda.workshop.core.NetworkDependencyProvider
import kotlinx.android.synthetic.main.activity_contributors.*

internal class ContributorsActivity : AppCompatActivity(), ContributorsPresenter.View {
    private val presenter: ContributorsPresenter
        get() {
            val userName = "tobiasheine"
            val token = "65912f6919f834fe937774509dd27d986efb7891"
            val networkDependencyProvider = NetworkDependencyProvider(userName, token)
            return ContributorsDependencyProvider(networkDependencyProvider).providePresenter()
        }

    private val contributorsAdapter = ContributorsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributors)
        title = getString(R.string.contributors_activity_title)
        contributorList.layoutManager = LinearLayoutManager(this)
        val contributorsAdapter = contributorsAdapter
        contributorList.adapter = contributorsAdapter
    }

    override fun onStart() {
        super.onStart()
        presenter.startPresenting(this)
    }

    override fun onStop() {
        presenter.stopPresenting()
        super.onStop()
    }

    override fun render(contributors: List<Contributor>) {
        contributorsAdapter.setContributors(contributors)
    }

    override fun showError(message: String?) {
        val errorMessage = message ?: getString(R.string.contributors_error)
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}
