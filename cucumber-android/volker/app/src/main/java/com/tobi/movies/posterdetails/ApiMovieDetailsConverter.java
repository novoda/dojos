package com.tobi.movies.posterdetails;

import com.tobi.movies.Converter;

import org.joda.time.LocalDate;

public class ApiMovieDetailsConverter implements Converter<ApiMovieDetails, MovieDetails> {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500/";

    @Override
    public MovieDetails convert(ApiMovieDetails input) {
        String imageUrl = IMAGE_BASE_URL + input.posterPath.substring(1, input.posterPath.length());
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
