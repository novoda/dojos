package com.novoda.phoneapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.novoda.core.apps.App

class PhoneApp : App {

    override fun launch(activity: Activity) {
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
