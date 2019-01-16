package com.novoda.workshop.credentials

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.novoda.workshop.R
import com.novoda.workshop.contributors.ContributorsActivity
import kotlinx.android.synthetic.main.activity_credentials.*


internal class CredentialsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credentials)
        show_contributors_button.setOnClickListener {
            val userName = user_name_input.text.toString()
            val token = token_input.text.toString()

            if (userName.isNotEmpty() && token.isNotEmpty()) {
                startActivity(ContributorsActivity.createIntent(this, userName, token))
            }
        }
    }
}
