package com.tobi.movies.popularstream;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tobi.movies.EspressoDependencies;
import com.tobi.movies.MovieApplication;
import com.tobi.movies.backend.ConfigurableBackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PopularMoviesActivityTest {

    private static final long MOVIE_ID = 293660L;
    private static final String POSTER_PATH = "deadpool.jpg";

    private final ActivityTestRule<PopularMoviesActivity> rule = new ActivityTestRule<PopularMoviesActivity>(PopularMoviesActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            MovieApplication movieApplication = (MovieApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
            movieApplication.setDependencies(new EspressoDependencies(backend));
        }
    };

    private final ConfigurableBackend backend = new ConfigurableBackend();

    private ApiMoviePoster apiMoviePoster;

    @Before
    public void setUp() throws Exception {
        apiMoviePoster = createApiMoviePoster(MOVIE_ID, POSTER_PATH);
    }

    @Test
    public void shouldShowPoster() throws Exception {
        backend.addToPopularStream(apiMoviePoster);

        PopularMoviesRobot
                .create()
                .launchPopularMovies(rule)
                .checkPosterWithPathIsDisplayedAtPosition(0, POSTER_PATH);
    }

    private ApiMoviePoster createApiMoviePoster(long movieId, String posterPath) {
        ApiMoviePoster poster = new ApiMoviePoster();
        poster.movieId = movieId;
        poster.posterPath = posterPath;
        return poster;
    }

}
