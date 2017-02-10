package com.tobi.movies.popularstream;

import android.app.Activity;
import android.content.Intent;

import com.tobi.movies.posterdetails.MovieDetailsActivity;

class Navigator {

    private final Activity activity;

    Navigator(Activity activity) {
        this.activity = activity;
    }

    void toMovieDetails(long movieId) {
        Intent intent = MovieDetailsActivity.createIntentFor(movieId, activity);
        activity.startActivity(intent);
    }
}
