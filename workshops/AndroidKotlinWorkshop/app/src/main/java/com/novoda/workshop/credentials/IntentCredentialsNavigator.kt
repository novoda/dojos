package com.novoda.workshop.credentials

import android.content.Context
import com.novoda.workshop.contributors.ContributorsActivity

class IntentCredentialsNavigator(private val context: Context) : CredentialsNavigator {

    override fun navigateToContributors(userName: String, token: String) {
        context.startActivity(
            ContributorsActivity.createIntent(
                context,
                userName,
                token
            )
        )
    }
}
