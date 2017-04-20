package com.tobi.movies.posterdetails;

import android.support.annotation.Nullable;

public interface MovieDetailsMVP {

    interface Model {

        @Nullable
        MovieDetails getMovieDetails();

        void loadMovieDetails(long movieId);
    }

    interface Presenter {
        void startPresenting(View movieDetailsView, long movieId);

        void stopPresenting();
    }

    interface View {
        void display(MovieDetails movieDetails);

        void showError();
    }
}
