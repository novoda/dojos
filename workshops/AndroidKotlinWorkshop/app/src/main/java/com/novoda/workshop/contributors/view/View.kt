package com.novoda.workshop.contributors.view

import com.novoda.workshop.contributors.data.Contributor

internal interface View {
    fun render(contributors: List<Contributor>)
    fun showError(message: String?)
}
