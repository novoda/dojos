package com.novoda.workshop.credentials.view


internal interface CredentialsView {
    fun showMissingCredentialsError()

    var onCredentialsSubmitted: (String, String) -> Unit
}
