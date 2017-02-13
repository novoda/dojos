package com.tobi.movies.steps;

import com.tobi.movies.Dependencies;
import com.tobi.movies.EspressoDependencies;
import com.tobi.movies.MovieApplication;
import com.tobi.movies.backend.ConfigurableBackend;
import com.tobi.movies.popularstream.ApiMoviePoster;
import com.tobi.movies.popularstream.PopularMoviesRobot;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import android.support.test.InstrumentationRegistry;

import java.util.Map;

public class PopularMoviesSteps {

    private final PopularMoviesRobot popularMoviesRobot = PopularMoviesRobot.create();

    @Given("^the following remote movie posters exist$")
    public void the_following_remote_movie_poster_exist(final DataTable dataTable) {
        extractPostersFromDataTable(dataTable);
    }

    @Given("^I open popular movies$")
    public void iOpenPopularMovies() throws Throwable {
        popularMoviesRobot.launchPopularMovies();
    }

    @Then("^I expect to see the poster path \"([^\"]*)\" for item (\\d+) in the list$")
    public void iExpectToSeeThePosterForItemInTheList(String posterPath, int position) throws Throwable {
        popularMoviesRobot.checkPosterWithPathIsDisplayedAtPosition(position, posterPath);
    }

    @When("^I tap on movie at position (\\d+)$")
    public void iTapOnMovieWithId(int position) throws Throwable {
        popularMoviesRobot.selectPosterAtPosition(position);
    }

    @Then("^I expect to see the movie details$")
    public void iExpectToSeeTheMovieDetails() throws Throwable {
        throw new PendingException();
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
}
