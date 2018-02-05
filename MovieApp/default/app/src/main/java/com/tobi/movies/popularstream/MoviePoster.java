package com.tobi.movies.popularstream;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MoviePoster {

    public abstract long movieId();

    public abstract String posterPath();

    static MoviePoster create(long movieId, String posterPath) {
        return new AutoValue_MoviePoster(movieId, posterPath);
    }

}
