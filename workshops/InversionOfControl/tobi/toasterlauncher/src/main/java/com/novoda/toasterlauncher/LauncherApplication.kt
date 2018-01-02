package com.novoda.toasterlauncher

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class LauncherApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
