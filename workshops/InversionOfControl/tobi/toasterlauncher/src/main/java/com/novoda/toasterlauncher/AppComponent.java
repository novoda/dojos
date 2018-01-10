package com.novoda.toasterlauncher;


import com.novoda.iockata.core.di.BuildersModule;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = { AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class })
public interface AppComponent extends AndroidInjector<LauncherApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<LauncherApplication> {
    }
}
