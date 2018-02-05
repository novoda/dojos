package com.tobi.movies.posterdetails;

import com.google.gson.annotations.SerializedName;

public class ApiMovieDetails {

    @SerializedName("id")
    public long movieId;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("release_date")
    public String releaseDate;
}
