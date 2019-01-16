package com.novoda.workshop.credentials

import android.content.Intent
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
            startActivity(Intent(this, ContributorsActivity::class.java))
        }
    }
}
