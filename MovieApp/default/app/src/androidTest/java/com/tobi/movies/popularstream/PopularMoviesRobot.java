package com.tobi.movies.popularstream;

import android.support.test.rule.ActivityTestRule;

import com.tobi.movies.R;
import com.tobi.movies.Robot;
import com.tobi.movies.matchers.PosterMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class PopularMoviesRobot extends Robot<PopularMoviesRobot> {

    public static PopularMoviesRobot create() {
        return new PopularMoviesRobot();
    }

    public PopularMoviesRobot() {
    }

    public PopularMoviesRobot launchPopularMovies(ActivityTestRule<PopularMoviesActivity> rule) {
        rule.launchActivity(null);
        return this;
    }

    public PopularMoviesRobot checkPosterWithPathIsDisplayedAtPosition(int position, String posterPath) {
        onView(withId(R.id.popularMovies_recycler))
                .check(matches(PosterMatcher.hasPosterAt(position, posterPath)));
        return this;
    }

    public PopularMoviesRobot selectPosterAtPosition(int position) {
        return selectPositionInRecyclerView(position, R.id.popularMovies_recycler);
    }
}
