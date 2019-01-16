package com.novoda.workshop.contributors

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.novoda.workshop.R
import com.novoda.workshop.User

internal class ContributorsAdapter : RecyclerView.Adapter<ContributorHolder>() {

    private val contributors = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contributor, parent, false)
        return ContributorHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ContributorHolder, position: Int) {
        viewHolder.bind(contributors[position])
    }

    override fun getItemCount(): Int = contributors.size

    fun setContributors(contributors: List<User>) {
        this.contributors.clear()
        this.contributors.addAll(contributors)
        notifyDataSetChanged()
    }

}
