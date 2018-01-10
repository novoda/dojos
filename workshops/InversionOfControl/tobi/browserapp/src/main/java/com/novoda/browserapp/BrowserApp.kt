package com.novoda.browserapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.novoda.core.apps.App


class BrowserApp : App {

    override fun launch(activity: Activity) {
        val url = "http://www.stackoverflow.com"
        val browserIntent = Intent(Intent.ACTION_VIEW)
        browserIntent.data = Uri.parse(url)

        if (browserIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(browserIntent)
        } else {
            Toast.makeText(activity, "Feature not supported :(", Toast.LENGTH_SHORT).show()
        }
    }

    override fun icon() = R.drawable.ic_browser

}
