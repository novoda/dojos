package com.tobi.movies;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.tobi.movies.popularstream.PopularStreamRepository;
import com.tobi.movies.posterdetails.MovieDetailsRepository;

import rx.Scheduler;

public class MovieApplication extends Application implements Dependencies {

    private Dependencies dependencies;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencies = new ApplicationDependencies();
    }

    @Override
    public ImageLoader imageLoader() {
        return dependencies.imageLoader();
    }

    @Override
    public PopularStreamRepository streamRepository() {
        return dependencies.streamRepository();
    }

    @Override
    public MovieDetailsRepository movieDetailsRepository() {
        return dependencies.movieDetailsRepository();
    }

    @Override
    public Scheduler createSubscriberThread() {
        return dependencies.createSubscriberThread();
    }

    @Override
    public Scheduler createObserverThread() {
        return dependencies.createObserverThread();
    }

    @VisibleForTesting
    public void setDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    @VisibleForTesting
    public Dependencies getDependencies() {
        return dependencies;
    }
}
