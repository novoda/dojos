package com.novoda.iockata.core.devicefeatures

import dagger.Module
import dagger.Provides

@Module
class DeviceFeatureModule {

    @Provides
    fun provideDeviceFeatures() : DeviceFeature = AndroidDeviceFeature()
}
