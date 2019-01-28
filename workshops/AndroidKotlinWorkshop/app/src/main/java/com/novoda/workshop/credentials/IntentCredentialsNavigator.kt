package com.novoda.workshop.credentials

import android.content.Context

class IntentCredentialsNavigator(private val context: Context) : CredentialsNavigator {

    override fun navigateToContributors(userName: String, token: String) {
        // TODO: Start explicit intent for ContributorsActivity including userName & token
        // See https://developer.android.com/training/basics/firstapp/starting-activity

        // val intent = ???
        // context.startActivity(intent)
    }
}
