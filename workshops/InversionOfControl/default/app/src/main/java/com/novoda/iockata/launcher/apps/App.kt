package com.novoda.iockata.launcher.apps

import android.support.annotation.DrawableRes


interface App {

    fun launch()

    @DrawableRes
    fun icon(): Int
}
