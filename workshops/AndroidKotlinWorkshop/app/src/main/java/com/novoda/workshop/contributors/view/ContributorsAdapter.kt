package com.novoda.workshop.contributors.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.novoda.workshop.R
import com.novoda.workshop.contributors.data.Contributor

internal class ContributorsAdapter : RecyclerView.Adapter<ContributorViewHolder>() {

    private val contributors = mutableListOf<Contributor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contributor, parent, false)
        return ContributorViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ContributorViewHolder, position: Int) {
        viewHolder.bind(contributors[position])
    }

    override fun getItemCount(): Int = contributors.size

    fun setContributors(contributors: List<Contributor>) {
        this.contributors.clear()
        this.contributors.addAll(contributors)
        notifyDataSetChanged()
    }

}
