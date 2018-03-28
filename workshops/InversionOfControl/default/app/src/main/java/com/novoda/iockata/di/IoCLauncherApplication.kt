package com.novoda.iockata.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class IoCLauncherApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out IoCLauncherApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}
