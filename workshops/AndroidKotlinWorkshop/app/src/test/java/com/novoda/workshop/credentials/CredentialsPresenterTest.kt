package com.novoda.workshop.credentials

import com.nhaarman.mockitokotlin2.KArgumentCaptor
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.novoda.workshop.credentials.view.CredentialsView
import org.junit.Before
import org.junit.Test

class CredentialsPresenterTest {
    private val view: CredentialsView = mock()
    private val navigator: CredentialsNavigator = mock()
    private val presenter = CredentialsPresenter(navigator)
    @Before
    fun setUp() {
        presenter.startPresenting(view)
    }

    @Test
    fun `shows error when empty user name submitted`() {
        val functionCapture = argumentCaptor<(String, String) -> Unit>()

        capturedSubmitFunction(functionCapture).invoke("", "token")

        verify(view).showMissingCredentialsError()
    }

    @Test
    fun `shows error when empty token submitted`() {
        val functionCapture = argumentCaptor<(String, String) -> Unit>()

        capturedSubmitFunction(functionCapture).invoke("name", "")

        verify(view).showMissingCredentialsError()
    }

    @Test
    fun `navigates to contributors`() {
        val functionCapture = argumentCaptor<(String, String) -> Unit>()

        capturedSubmitFunction(functionCapture).invoke("name", "token")

        verify(navigator).navigateToContributors(userName = "name", token = "token")
    }

    private fun capturedSubmitFunction(functionCapture: KArgumentCaptor<(String, String) -> Unit>): (String, String) -> Unit {
        verify(view).onCredentialsSubmitted = functionCapture.capture()
        return functionCapture.firstValue
    }
}
