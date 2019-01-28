package com.novoda.workshop.contributors

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.novoda.workshop.R
import com.novoda.workshop.contributors.data.Contributor
import com.novoda.workshop.contributors.view.ContributorsAdapter
import com.novoda.workshop.contributors.view.View
import kotlinx.android.synthetic.main.activity_contributors.*

// TODO: The IDE gives you a hint that this activity is not yet registered in the manifest.
// Either add it manually or follow the hints (option + return) to do this.
internal class ContributorsActivity : AppCompatActivity(), View {

    private lateinit var presenter: ContributorsPresenter
    private val contributorsAdapter = ContributorsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributors)
        title = getString(R.string.contributors_activity_title)
        contributorList.layoutManager = LinearLayoutManager(this)
        contributorList.adapter = contributorsAdapter
        presenter = createPresenter(intent)
    }

    // TODO: Create the presenter using data we passed via the intent
    private fun createPresenter(intent: Intent): ContributorsPresenter {
        val userName = ""
        val token = ""
        return ContributorsDependencyProvider(userName, token).providePresenter()
    }

    // TODO: Start/Stop the presenter based on the Activity lifecycle
    // https://developer.android.com/reference/android/app/Activity.html#onStart()
    // https://developer.android.com/reference/android/app/Activity.html#onStop()

    override fun render(contributors: List<Contributor>) {
        contributorsAdapter.setContributors(contributors)
    }

    override fun showError(message: String?) {
        val errorMessage = message ?: getString(R.string.contributors_error)
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

}
