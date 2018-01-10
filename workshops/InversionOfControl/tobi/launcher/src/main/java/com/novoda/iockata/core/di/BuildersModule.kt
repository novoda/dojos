package com.novoda.iockata.core.di

import com.novoda.launcher.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuildersModule {

    @ContributesAndroidInjector()
    abstract fun launcherActivity(): LauncherActivity
}
