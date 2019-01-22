package com.novoda.workshop.credentials


internal interface CredentialsNavigator {

    fun navigateToContributors(userName: String, token: String)
}
