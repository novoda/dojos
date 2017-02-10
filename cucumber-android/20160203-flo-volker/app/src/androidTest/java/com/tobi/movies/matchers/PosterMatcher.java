package com.tobi.movies.matchers;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tobi.movies.popularstream.MoviePoster;
import com.tobi.movies.popularstream.MoviePosterAdapter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class PosterMatcher {

    public static Matcher<? super View> hasPosterAt(final int position, final String posterPath) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has poster with path:" + posterPath + " at position:" + position);
            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {
                MoviePosterAdapter adapter = (MoviePosterAdapter) item.getAdapter();
                MoviePoster moviePoster = adapter.getItemAt(position);
                return moviePoster.posterPath().contains(posterPath);
            }
        };
    }
}
