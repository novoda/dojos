package com.tobi.movies.popularstream;

import android.support.annotation.NonNull;

import com.tobi.movies.BuildConfig;
import com.tobi.movies.backend.Backend;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class PopularStreamApiDatasource {

    private final Backend backend;

    public PopularStreamApiDatasource(Backend backend) {
        this.backend = backend;
    }

    public Observable<List<ApiMoviePoster>> getPopularPosters() {
        return backend.popularStream(BuildConfig.API_KEY)
                .map(tApiMoviePosters());
    }

    @NonNull
    private Func1<ApiPopularMoviesResponse, List<ApiMoviePoster>> tApiMoviePosters() {
        return new Func1<ApiPopularMoviesResponse, List<ApiMoviePoster>>() {
            @Override
            public List<ApiMoviePoster> call(ApiPopularMoviesResponse apiPopularMoviesResponse) {
                return apiPopularMoviesResponse.results;
            }
        };
    }

}
