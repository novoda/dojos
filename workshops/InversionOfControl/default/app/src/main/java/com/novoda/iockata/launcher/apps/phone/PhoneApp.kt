package com.novoda.iockata.launcher.apps.phone

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.novoda.iockata.R
import com.novoda.iockata.launcher.apps.App

class PhoneApp(private val activity: Activity) : App {

    override fun launch() {
        val phoneIntent = Intent(Intent.ACTION_DIAL)
        phoneIntent.data = Uri.parse("tel:0123456789")

        if (phoneIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(phoneIntent)
        } else {
            Toast.makeText(activity, "Feature not supported :(", Toast.LENGTH_SHORT).show()
        }
    }

    override fun icon(): Int {
        return R.drawable.ic_phone
    }

}
