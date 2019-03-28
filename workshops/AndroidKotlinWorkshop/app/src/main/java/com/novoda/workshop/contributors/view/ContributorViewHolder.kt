package com.novoda.workshop.contributors.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.novoda.workshop.contributors.data.Contributor
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_contributor.*

internal class ContributorViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

    fun bind(contributor: Contributor) {
        contributor_name.text = contributor.name
        contributor_contributions.text = "${contributor.contributions}"
        contributor_image.loadImageFrom(contributor.avatarUrl)
    }

}

private fun ImageView.loadImageFrom(avatarUrl: String) {
    Glide.with(context).load(GlideUrl(avatarUrl))
            .into(this)
}
