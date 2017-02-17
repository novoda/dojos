package com.tobi.movies.posterdetails;

import com.tobi.movies.Converter;

import org.joda.time.LocalDate;

public class ApiMovieDetailsAssetConverter implements Converter<ApiMovieDetails, MovieDetails> {

    private final static String ASSET_PATH = "file:///android_asset/";

    @Override
    public MovieDetails convert(ApiMovieDetails input) {
        String imageUrl = ASSET_PATH + input.posterPath.substring(0, input.posterPath.length());
        LocalDate releaseDate = new LocalDate(input.releaseDate);

        return MovieDetails.builder().
                movieId(input.movieId).
                originalTitle(input.originalTitle).
                overview(input.overview).
                posterPath(imageUrl).
                releaseDate(releaseDate).
                build();
    }
}
