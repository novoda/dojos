package com.novoda.workshop.contributors.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.novoda.workshop.R
import com.novoda.workshop.contributors.data.Contributor
import kotlinx.android.extensions.LayoutContainer

internal class ContributorsAdapter : RecyclerView.Adapter<ContributorViewHolder>() {

    private val contributors = mutableListOf<Contributor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contributor, parent, false)
        TODO("Create and return a ContributorViewHolder")
    }

    override fun onBindViewHolder(viewHolder: ContributorViewHolder, position: Int) {
        //TODO: Bind view holder to contributor at the given position
    }

    override fun getItemCount(): Int = TODO("Return contributors count")

    fun setContributors(contributors: List<Contributor>) {
        //TODO: Update list of contributors and notify that the data has been changed
        notifyDataSetChanged()
    }

}

internal class ContributorViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

    private val resources = containerView.resources

    fun bind(contributor: Contributor) {
        // TODO: Set label text to contributor_label
        // TODO: Load avatar into contributor_image
    }

    private fun labelFrom(contributor: Contributor) =
        resources.getString(R.string.contributor_item_label, contributor.name, contributor.contributions)

}

private fun ImageView.loadImageFrom(avatarUrl: String) {
    Glide.with(context).load(GlideUrl(avatarUrl))
            .into(this)
}
