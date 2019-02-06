package com.novoda.workshop.credentials

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.novoda.workshop.R
import com.novoda.workshop.credentials.view.CredentialsView
import kotlinx.android.synthetic.main.activity_credentials.*


internal class CredentialsActivity : AppCompatActivity(), CredentialsView {
    override var onCredentialsSubmitted: (String, String) -> Unit = { _, _ -> }

    private lateinit var presenter: CredentialsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credentials)
        show_contributors_button.setOnClickListener {
            // TODO: Pass credentials to presenter on button click
            val userName = ""
            val token = ""
            onCredentialsSubmitted(userName, token)
        }
        presenter = CredentialsDependencyProvider(this).providePresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.startPresenting(this)
    }

    override fun onStop() {
        presenter.stopPresenting()
        super.onStop()
    }

    override fun showMissingCredentialsError() {
        Toast.makeText(this, getString(R.string.credentials_missing_error), Toast.LENGTH_LONG).show()
    }
}

