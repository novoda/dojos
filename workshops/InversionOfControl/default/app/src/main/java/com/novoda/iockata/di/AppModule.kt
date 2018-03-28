package com.novoda.iockata.di

import android.content.Context
import com.novoda.iockata.core.devicefeatures.DeviceFeatureModule
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(DeviceFeatureModule::class))
class AppModule {

    @Provides fun provideContext(application: IoCLauncherApplication): Context = application.applicationContext
}
