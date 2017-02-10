package com.tobi.movies.popularstream;

import com.google.gson.annotations.SerializedName;

public class ApiMoviePoster {

    @SerializedName("id")
    public long movieId;

    @SerializedName("poster_path")
    public String posterPath;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ApiMoviePoster that = (ApiMoviePoster) o;

        return movieId == that.movieId
                && posterPath != null ? posterPath.equals(that.posterPath) : that.posterPath == null;
    }

    @Override
    public int hashCode() {
        int result = posterPath != null ? posterPath.hashCode() : 0;
        result = 31 * result + (int) (movieId ^ (movieId >>> 32));
        return result;
    }
}
