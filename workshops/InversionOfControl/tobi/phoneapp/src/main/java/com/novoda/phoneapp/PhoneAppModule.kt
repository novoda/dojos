package com.novoda.phoneapp

import com.novoda.core.apps.App
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class PhoneAppModule {

    @Provides
    @IntoSet
    fun providePhoneAppIntoSet(): App = PhoneApp()

}
