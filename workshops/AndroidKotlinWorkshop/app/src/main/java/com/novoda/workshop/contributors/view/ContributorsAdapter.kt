package com.novoda.workshop.contributors.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.novoda.workshop.contributors.data.Contributor

internal class ContributorsAdapter : RecyclerView.Adapter<ContributorViewHolder>() {

    private val contributors = mutableListOf<Contributor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        TODO("Return a ContributorViewHolder")
    }

    override fun onBindViewHolder(viewHolder: ContributorViewHolder, position: Int) {
        TODO("Bind viewHolder to a contributor at the given position")
    }

    override fun getItemCount(): Int = TODO("Return contributors count")

    fun setContributors(newContributors: List<Contributor>) {
        TODO("Replace old contributors with new ones")
        notifyDataSetChanged()
    }

}

