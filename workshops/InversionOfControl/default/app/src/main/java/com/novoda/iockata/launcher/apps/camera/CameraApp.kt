package com.novoda.iockata.launcher.apps.camera

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast
import com.novoda.iockata.R
import com.novoda.iockata.launcher.apps.App


class CameraApp(private val activity: Activity) : App {

    override fun launch() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivityForResult(takePictureIntent, 1)
        } else {
            Toast.makeText(activity, "Feature not supported :(", Toast.LENGTH_SHORT).show()
        }
    }

    override fun icon() = R.drawable.ic_camera
}
