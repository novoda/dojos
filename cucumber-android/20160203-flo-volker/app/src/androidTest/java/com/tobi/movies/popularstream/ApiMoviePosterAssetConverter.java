package com.tobi.movies.popularstream;

import com.tobi.movies.Converter;

public class ApiMoviePosterAssetConverter implements Converter<ApiMoviePoster, MoviePoster> {

    private final static String ASSET_PATH = "file:///android_asset/";

    @Override
    public MoviePoster convert(ApiMoviePoster input) {
        String imageUrl = ASSET_PATH + input.posterPath.substring(0, input.posterPath.length());
        return MoviePoster.create(input.movieId, imageUrl);
    }
}
