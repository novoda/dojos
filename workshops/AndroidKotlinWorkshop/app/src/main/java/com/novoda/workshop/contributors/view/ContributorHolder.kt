package com.novoda.workshop.contributors.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.novoda.workshop.R
import com.novoda.workshop.contributors.data.Contributor
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_contributor.*

internal class ContributorHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private val resources = containerView.resources

    fun bind(contributor: Contributor) {
        contributor_label.text = labelFrom(contributor)
        contributor_image.loadImageFrom(contributor.avatarUrl)
    }

    private fun labelFrom(contributor: Contributor) =
        resources.getString(R.string.contributor_item_label, contributor.name, contributor.contributions)

}

private fun ImageView.loadImageFrom(avatarUrl: String) {
    Glide.with(context).load(GlideUrl(avatarUrl))
        .into(this)
}
