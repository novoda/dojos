package com.novoda.toasterapp

import android.app.Activity
import android.widget.Toast
import com.novoda.core.apps.App

class ToasterApp : App {

    override fun launch(activity: Activity) {
        Toast.makeText(activity, "Enjoy your toast ^^", Toast.LENGTH_SHORT).show()
    }

    override fun icon() = R.drawable.ic_toaster
}
