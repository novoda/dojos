package com.novoda.launcher

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.novoda.core.apps.App

class AppAdapter(private val apps: List<App>, private val activity: Activity) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount() = apps.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val widgetView = LayoutInflater.from(parent.context).inflate(R.layout.widget, parent, false)
        return ViewHolder(widgetView as ImageView)
    }

    inner class ViewHolder(itemView: ImageView) : RecyclerView.ViewHolder(itemView) {

        fun bind(app: App) {
            (itemView as ImageView).setBackgroundResource(app.icon())
            itemView.setOnClickListener {
                app.launch(activity)
            }
        }

    }
}
