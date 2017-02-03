package com.tobi.movies.steps;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.tobi.movies.Dependencies;
import com.tobi.movies.EspressoDependencies;
import com.tobi.movies.MovieApplication;
import com.tobi.movies.backend.ConfigurableBackend;
import com.tobi.movies.popularstream.ApiMoviePoster;
import com.tobi.movies.popularstream.PopularMoviesActivity;
import com.tobi.movies.popularstream.PopularMoviesRobot;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PopularMoviesSteps {

    private final PopularMoviesRobot popularMoviesRobot = PopularMoviesRobot.create();

    @Given("^the following remote movie posters exist$")
    public void the_following_remote_movie_poster_exist(final DataTable dataTable) {
        extractPostersFromDataTable(dataTable);
    }

    private void extractPostersFromDataTable(DataTable dataTable) {
        ConfigurableBackend configurableBackend = getConfigurableBackend();

        for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            Long movieId = Long.valueOf(row.get("movieId"));
            String posterPath = row.get("posterPath");

            configurableBackend.addToPopularStream(createApiMoviePoster(movieId, posterPath));
        }
    }

    private ApiMoviePoster createApiMoviePoster(long movieId, String posterPath) {
        ApiMoviePoster poster = new ApiMoviePoster();
        poster.movieId = movieId;
        poster.posterPath = posterPath;
        return poster;
    }

    private ConfigurableBackend getConfigurableBackend() {
        MovieApplication movieApplication = (MovieApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        Dependencies dependencies = movieApplication.getDependencies();
        return ((EspressoDependencies) dependencies).getConfigurableBackend();
    }

    @When("^Launch poster overview screen$")
    public void launchPosterOverviewScreen() throws Throwable {
        popularMoviesRobot.launchPopularMovies(new ActivityTestRule<>(PopularMoviesActivity.class));
    }

    @Then("^I expect to see movie poster with url \"([^\"]*)\" at position (\\d+)$")
    public void iExpectToSeeMoviePosterWithUrlAtPosition(String posterUrl, int position) throws Throwable {
        popularMoviesRobot.checkPosterWithPathIsDisplayedAtPosition(position, posterUrl);;
    }
}
