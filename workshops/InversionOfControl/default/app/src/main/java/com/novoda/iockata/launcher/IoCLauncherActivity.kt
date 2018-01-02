package com.novoda.iockata.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.novoda.iockata.R
import com.novoda.iockata.core.devicefeatures.DeviceFeature
import com.novoda.iockata.core.di.IoCLauncherApplication
import com.novoda.iockata.launcher.apps.AppAdapter
import dagger.android.AndroidInjection
import javax.inject.Inject

class IoCLauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var deviceFeature: DeviceFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        title = "IoC Launcher"
        AndroidInjection.inject(this)

        val appsList = findViewById<RecyclerView>(R.id.apps)
        appsList.layoutManager = GridLayoutManager(this, 3)
        appsList.adapter = AppAdapter(this, deviceFeature)
    }
}

