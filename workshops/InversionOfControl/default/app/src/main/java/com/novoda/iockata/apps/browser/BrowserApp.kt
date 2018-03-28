package com.novoda.iockata.apps.browser

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.novoda.iockata.R
import com.novoda.iockata.apps.App


class BrowserApp(private val activity: Activity) : App {

    override fun launch() {
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
