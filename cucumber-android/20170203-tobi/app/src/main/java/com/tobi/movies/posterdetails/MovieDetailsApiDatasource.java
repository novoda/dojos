package com.tobi.movies.posterdetails;

import com.tobi.movies.BuildConfig;
import com.tobi.movies.backend.Backend;

import rx.Observable;

public class MovieDetailsApiDatasource {

    private final Backend backend;

    public MovieDetailsApiDatasource(Backend backend) {
        this.backend = backend;
    }

    public Observable<ApiMovieDetails> getMovieDetails(long movieId) {
        return backend.movieDetails(movieId, BuildConfig.API_KEY);
    }
}
