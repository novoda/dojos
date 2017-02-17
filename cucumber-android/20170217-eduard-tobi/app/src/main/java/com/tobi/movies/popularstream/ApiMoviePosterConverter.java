package com.tobi.movies.popularstream;

import com.tobi.movies.Converter;

public class ApiMoviePosterConverter implements Converter<ApiMoviePoster, MoviePoster> {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500/";

    @Override
    public MoviePoster convert(ApiMoviePoster input) {
        String imageUrl = IMAGE_BASE_URL + input.posterPath.substring(1, input.posterPath.length());
        return MoviePoster.create(input.movieId, imageUrl);
    }
}
