package com.novoda.toasterlauncher

import android.content.Context
import com.novoda.toasterapp.ToasterAppModule
import dagger.Module
import dagger.Provides


@Module(includes = arrayOf(ToasterAppModule::class))
class AppModule {

    @Provides fun provideContext(application: LauncherApplication): Context {
        return application.applicationContext
    }

}
