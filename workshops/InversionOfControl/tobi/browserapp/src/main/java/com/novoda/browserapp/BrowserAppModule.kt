package com.novoda.browserapp

import com.novoda.core.apps.App
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class BrowserAppModule {

    @Provides
    @IntoSet
    fun provideAppIntoSet(): App = BrowserApp()

}
