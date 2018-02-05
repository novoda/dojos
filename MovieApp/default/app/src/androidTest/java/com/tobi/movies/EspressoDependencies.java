package com.tobi.movies;

import android.os.AsyncTask;

import com.tobi.movies.backend.Backend;
import com.tobi.movies.backend.ConfigurableBackend;
import com.tobi.movies.popularstream.ApiMoviePoster;
import com.tobi.movies.popularstream.ApiMoviePosterAssetConverter;
import com.tobi.movies.popularstream.MoviePoster;
import com.tobi.movies.posterdetails.ApiMovieDetails;
import com.tobi.movies.posterdetails.ApiMovieDetailsAssetConverter;
import com.tobi.movies.posterdetails.MovieDetails;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class EspressoDependencies extends ApplicationDependencies {

    private final ConfigurableBackend backend;

    public EspressoDependencies() {
        this(new ConfigurableBackend());
    }

    public EspressoDependencies(ConfigurableBackend backend) {
        this.backend = backend;
    }

    @Override
    protected Converter<ApiMovieDetails, MovieDetails> createMovieDetailsConverter() {
        return new ApiMovieDetailsAssetConverter();
    }

    @Override
    protected Converter<ApiMoviePoster, MoviePoster> createPosterConverter() {
        return new ApiMoviePosterAssetConverter();
    }

    @Override
    protected Backend createBackend() {
        return backend;
    }

    @Override
    public Scheduler createSubscriberThread() {
        // IdlingResource is not needed since espresso waits for AsyncTask.THREAD_POOL_EXECUTOR
        return Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public ConfigurableBackend getConfigurableBackend() {
        return backend;
    }
}
