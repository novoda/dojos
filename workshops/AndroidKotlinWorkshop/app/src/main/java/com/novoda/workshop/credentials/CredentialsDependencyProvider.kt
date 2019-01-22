package com.novoda.workshop.credentials

import android.content.Context


internal class CredentialsDependencyProvider(private val context: Context) {

    private fun provideNavigator(): CredentialsNavigator = IntentCredentialsNavigator(context)

    fun providePresenter(): CredentialsPresenter = CredentialsPresenter(provideNavigator())
}
