package com.novoda.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.novoda.core.apps.App
import dagger.android.AndroidInjection
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var apps: MutableSet<App>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        title = "IoC Launcher"
        AndroidInjection.inject(this)

        val appsList = findViewById<RecyclerView>(R.id.apps)
        appsList.layoutManager = GridLayoutManager(this, 3)
        appsList.adapter = AppAdapter(apps.toList(), this)
    }
}

