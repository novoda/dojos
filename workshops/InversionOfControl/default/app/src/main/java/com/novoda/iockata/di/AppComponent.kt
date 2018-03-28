package com.novoda.iockata.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuildersModule::class))
abstract class AppComponent: AndroidInjector<IoCLauncherApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<IoCLauncherApplication>()

}
