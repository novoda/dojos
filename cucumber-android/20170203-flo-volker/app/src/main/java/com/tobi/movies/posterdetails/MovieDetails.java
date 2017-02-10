package com.tobi.movies.posterdetails;

import com.google.auto.value.AutoValue;

import org.joda.time.LocalDate;

@AutoValue
public abstract class MovieDetails {

    public abstract String overview();
    public abstract long movieId();
    public abstract String originalTitle();
    public abstract String posterPath();
    public abstract LocalDate releaseDate();

    static Builder builder() {
        return new AutoValue_MovieDetails.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder overview(String overview);

        abstract Builder movieId(long movieId);

        abstract Builder originalTitle(String originalTitle);

        abstract Builder posterPath(String posterPath);

        abstract Builder releaseDate(LocalDate releaseDate);

        abstract MovieDetails build();
    }
}
