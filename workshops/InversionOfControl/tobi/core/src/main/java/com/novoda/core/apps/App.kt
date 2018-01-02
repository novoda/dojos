package com.novoda.core.apps

import android.app.Activity
import android.support.annotation.DrawableRes


interface App {

    fun launch(activity: Activity)

    @DrawableRes
    fun icon(): Int
}
