package com.novoda.iockata.launcher

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.novoda.iockata.R
import com.novoda.iockata.core.devicefeatures.DeviceFeature
import com.novoda.iockata.launcher.apps.App
import com.novoda.iockata.launcher.apps.camera.CameraApp
import com.novoda.iockata.launcher.apps.phone.PhoneApp
import com.novoda.iockata.launcher.apps.toaster.ToasterApp

class AppAdapter(activity: Activity, deviceFeature: DeviceFeature) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    private val apps: List<App>

    init {
        apps = mutableListOf()

        if (deviceFeature.canDial()) {
            apps.add(PhoneApp(activity))
        }

        if (deviceFeature.canShootPhoto()) {
            apps.add(CameraApp(activity))
        }

        if (deviceFeature.canToast()) {
            apps.add(ToasterApp(activity))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount() = apps.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val widgetView = LayoutInflater.from(parent.context).inflate(R.layout.widget, parent, false)
        return ViewHolder(widgetView as ImageView)
    }

    class ViewHolder(itemView: ImageView) : RecyclerView.ViewHolder(itemView) {

        fun bind(app: App) {
            (itemView as ImageView).setBackgroundResource(app.icon())
            itemView.setOnClickListener {
                app.launch()
            }
        }

    }
}
