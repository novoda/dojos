package com.tobi.movies.posterdetails;

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
public class MovieDetailsActivityTest {

    private static final long MOVIE_ID = 293660L;
    private static final String MOVIE_TITLE = "Deadpool";
    private static final String MOVIE_DESCRIPTION = "Such an awesome movie!";
    private static final String POSTER_PATH = "deadpool.jpg";
    private static final String RELEASE_DATE = "2001-01-01";

    private ConfigurableBackend backend = new ConfigurableBackend();

    private ActivityTestRule<MovieDetailsActivity> rule = new ActivityTestRule<MovieDetailsActivity>(MovieDetailsActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            MovieApplication movieApplication = (MovieApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
            movieApplication.setDependencies(new EspressoDependencies(backend));
        }
    };
    private ApiMovieDetails apiMovieDetails;

    @Before
    public void setUp() throws Exception {
        apiMovieDetails = createApiMovieDetails(MOVIE_ID, MOVIE_TITLE, MOVIE_DESCRIPTION, POSTER_PATH, RELEASE_DATE);
    }

    @Test
    public void shouldShowMovieTitle() throws Exception {
        backend.addMovieDetails(apiMovieDetails);

        PosterDetailsRobot.create()
                .launchDetailsScreen(MOVIE_ID, rule)
                .checkMovieTitleIsDisplayed(MOVIE_TITLE)
                .checkMovieDescriptionIsDisplayed(MOVIE_DESCRIPTION);
    }

    @Test
    public void shouldShowMovieReleaseDate() {
        backend.addMovieDetails(apiMovieDetails);

        PosterDetailsRobot.create()
                .launchDetailsScreen(MOVIE_ID, rule)
                .checkMovieReleaseDateIsDisplayed(RELEASE_DATE);
    }

    private ApiMovieDetails createApiMovieDetails(long movieId, String movieTitle, String movieOverview, String posterPath, String releaseDate) {
        ApiMovieDetails apiMovieDetails = new ApiMovieDetails();
        apiMovieDetails.originalTitle = movieTitle;
        apiMovieDetails.movieId = movieId;
        apiMovieDetails.overview = movieOverview;
        apiMovieDetails.posterPath = posterPath;
        apiMovieDetails.releaseDate = releaseDate;

        return apiMovieDetails;
    }
}
