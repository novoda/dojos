package com.tobi.movies.steps;

import android.support.test.InstrumentationRegistry;

import com.tobi.movies.EspressoDependencies;
import com.tobi.movies.MovieApplication;
import com.tobi.movies.utils.ActivityFinisher;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetupSteps {

    @Before()
    public void setup() {
        setupEspressoDependencies();
    }

    private void setupEspressoDependencies() {
        MovieApplication movieApplication = (MovieApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        movieApplication.setDependencies(new EspressoDependencies());
    }

    @After
    public void tearDown() {
        ActivityFinisher.finishOpenActivities(); // Required for testing App with multiple activities
    }
}
