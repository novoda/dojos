package com.novoda.workshop.contributors

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.novoda.workshop.R
import com.novoda.workshop.User
import com.novoda.workshop.core.NetworkDependencyProvider
import kotlinx.android.synthetic.main.activity_contributers.*

internal class ContributorsActivity : AppCompatActivity(), ContributorsPresenter.View {
    private val presenter: ContributorsPresenter
        get() {
            val userName = "XXX"
            val token = "XXX"
            val networkDependencyProvider = NetworkDependencyProvider(userName, token)
            return ContributorsDependencyProvider(networkDependencyProvider).providePresenter()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributers)
    }

    override fun onStart() {
        super.onStart()
        presenter.startPresenting(this)
    }

    override fun onStop() {
        presenter.stopPresenting()
        super.onStop()
    }

    override fun render(contributors: List<User>) {
        label.text = contributors.size.toString()
    }

    override fun showError(message: String?) {
        label.text = message ?: getString(R.string.contributors_error)
    }
}
