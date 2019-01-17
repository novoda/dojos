package com.novoda.workshop.credentials

import com.novoda.workshop.credentials.view.CredentialsView


internal class CredentialsPresenter(private val navigator: CredentialsNavigator) {

    private lateinit var view: CredentialsView

    fun startPresenting(view: CredentialsView) {
        this.view = view
        this.view.onCredentialsSubmitted = { userName, token ->
            if (userName.isNotEmpty() && token.isNotEmpty()) {
                navigator.navigateToContributors(userName, token)
            } else {
                view.showMissingCredentialsError()
            }
        }
    }

    fun stopPresenting() {
        this.view.onCredentialsSubmitted = { _, _ -> }
    }
}
