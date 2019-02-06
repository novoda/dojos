package com.novoda.workshop.credentials

import com.novoda.workshop.credentials.view.CredentialsView


internal class CredentialsPresenter(private val navigator: CredentialsNavigator) {

    private lateinit var view: CredentialsView

    fun startPresenting(view: CredentialsView) {
        this.view = view
    }

    fun stopPresenting() {
        // no op
    }
}
