package com.novoda.iockata.core.di;


import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = { AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class })
public interface AppComponent extends AndroidInjector<LauncherApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<LauncherApplication> {
    }
}
