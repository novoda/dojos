package com.tobi.movies.popularstream;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPopularMoviesResponse {

    @SerializedName("results")
    List<ApiMoviePoster> results;
}
