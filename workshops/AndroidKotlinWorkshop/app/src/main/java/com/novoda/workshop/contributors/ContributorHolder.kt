package com.novoda.workshop.contributors

import android.support.v7.widget.RecyclerView
import android.view.View
import com.novoda.workshop.R
import com.novoda.workshop.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_contributor.*

internal class ContributorHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private val resources = containerView.resources

    fun bind(user: User) {
        contributor_label.text = labelFrom(user)
    }

    private fun labelFrom(user: User) =
        resources.getString(R.string.contributor_label, user.login, user.contributions)

}
