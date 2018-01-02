package com.novoda.iockata.core.di

import android.content.Context
import com.novoda.browserapp.BrowserAppModule
import com.novoda.phoneapp.PhoneAppModule
import com.novoda.toasterapp.ToasterAppModule
import dagger.Module
import dagger.Provides


@Module(includes = arrayOf(PhoneAppModule::class, BrowserAppModule::class, ToasterAppModule::class))
class AppModule {

    @Provides fun provideContext(application: LauncherApplication): Context {
        return application.applicationContext
    }

}
