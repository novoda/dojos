package com.novoda.workshop.contributors

import android.content.Context
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

private const val EXTRA_USER_NAME = "extra_user_name"
private const val EXTRA_TOKEN = "extra_token"

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

    private fun createPresenter(intent: Intent): ContributorsPresenter {
        val userName = intent.getStringExtra(EXTRA_USER_NAME)
        val token = intent.getStringExtra(EXTRA_TOKEN)
        return ContributorsDependencyProvider(userName, token).providePresenter()
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

    companion object {
        fun createIntent(context: Context, userName: String, token: String): Intent {
            val intent = Intent(context, ContributorsActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, userName)
            intent.putExtra(EXTRA_TOKEN, token)
            return intent
        }
    }
}
