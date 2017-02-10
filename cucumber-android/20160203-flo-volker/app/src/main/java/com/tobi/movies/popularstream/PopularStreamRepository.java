package com.tobi.movies.popularstream;

import android.support.annotation.NonNull;

import com.tobi.movies.Converter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

public class PopularStreamRepository {

    private final PopularStreamApiDatasource popularStreamApiDatasource;
    private final Scheduler subscribeScheduler;
    private final Scheduler observeScheduler;
    private final Converter<ApiMoviePoster, MoviePoster> posterConverter;

    public PopularStreamRepository(PopularStreamApiDatasource popularStreamApiDatasource, Scheduler subscribeScheduler, Scheduler observeScheduler,
                            Converter<ApiMoviePoster, MoviePoster> posterConverter) {
        this.popularStreamApiDatasource = popularStreamApiDatasource;
        this.subscribeScheduler = subscribeScheduler;
        this.observeScheduler = observeScheduler;
        this.posterConverter = posterConverter;
    }

    public Observable<List<MoviePoster>> getPopularPosters() {
        return popularStreamApiDatasource.getPopularPosters()
                .map(toMoviePosters())
                .observeOn(observeScheduler)
                .subscribeOn(subscribeScheduler);
    }

    @NonNull
    private Func1<List<ApiMoviePoster>, List<MoviePoster>> toMoviePosters() {
        return new Func1<List<ApiMoviePoster>, List<MoviePoster>>() {
            @Override
            public List<MoviePoster> call(List<ApiMoviePoster> apiMoviePosters) {
                List<MoviePoster> result = new ArrayList<>(apiMoviePosters.size());

                for (ApiMoviePoster apiMoviePoster : apiMoviePosters) {
                    result.add(toMoviePoster(apiMoviePoster));
                }

                return result;
            }
        };
    }

    private MoviePoster toMoviePoster(ApiMoviePoster apiMoviePoster) {
        return posterConverter.convert(apiMoviePoster);
    }

}
