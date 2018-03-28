package com.novoda.iockata.apps.toaster

import android.app.Activity
import android.widget.Toast
import com.novoda.iockata.R
import com.novoda.iockata.apps.App

class ToasterApp(private val activity: Activity) : App {

    override fun launch() {
        Toast.makeText(activity, "Enjoy your toast ^^", Toast.LENGTH_SHORT).show()
    }

    override fun icon() = R.drawable.ic_toaster
}
