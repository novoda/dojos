package com.novoda.toasterapp

import com.novoda.core.apps.App
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ToasterAppModule {

    @Provides
    @IntoSet
    fun provideAppIntoSet(): App = ToasterApp()

}
