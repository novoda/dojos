package com.tobi.movies.popularstream;

import java.util.List;

public class PublicApiPopularMoviesResponse extends ApiPopularMoviesResponse {

    public PublicApiPopularMoviesResponse(List<ApiMoviePoster> results) {
        this.results = results;
    }

}
