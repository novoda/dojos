package com.tobi.movies.posterdetails;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.tobi.movies.R;
import com.tobi.movies.Robot;

public class PosterDetailsRobot extends Robot<PosterDetailsRobot> {

    public static PosterDetailsRobot create() {
        return new PosterDetailsRobot();
    }

    public PosterDetailsRobot() {
    }

    public PosterDetailsRobot checkMovieTitleIsDisplayed(String movieTitle) {
        return checkTextIsDisplayed(movieTitle, R.id.movieTitle);
    }

    public PosterDetailsRobot launchDetailsScreen(long movieId) {
        return launchDetailsScreen(movieId, new ActivityTestRule<>(MovieDetailsActivity.class));
    }

    public PosterDetailsRobot launchDetailsScreen(long movieId, ActivityTestRule<MovieDetailsActivity> testRule) {
        testRule.launchActivity(MovieDetailsActivity.createIntentFor(movieId, InstrumentationRegistry.getInstrumentation()
                .getTargetContext()
                .getApplicationContext()));
        return new PosterDetailsRobot();
    }

    public PosterDetailsRobot checkMovieDescriptionIsDisplayed(String movieDescription) {
        return checkTextIsDisplayed(movieDescription, R.id.movieOverview);
    }

    public PosterDetailsRobot checkMovieReleaseDateIsDisplayed(String releaseDate) {
        return checkTextIsDisplayed(releaseDate,  R.id.movieReleaseDate);
    }
}
