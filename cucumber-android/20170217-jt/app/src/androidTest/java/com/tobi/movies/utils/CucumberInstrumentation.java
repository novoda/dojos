package com.tobi.movies.utils;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

import com.tobi.movies.BuildConfig;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberInstrumentation extends AndroidJUnitRunner {

    private static final String CUCUMBER_TAGS_KEY = "tags";
    public static final String CUCUMBER_SCENARIO_KEY = "name";
    private static final String CUCUMBER_FEATURE_KEY = "features";

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        String tags = BuildConfig.TEST_TAGS;
        if (!tags.isEmpty()) {
            String tagsKey = tags.replaceAll("\\s", "");
            bundle.putString(CUCUMBER_TAGS_KEY, tagsKey);
        }

        String scenario = BuildConfig.TEST_SCENARIO;
        if (!scenario.isEmpty()) {
            scenario = scenario.replaceAll(" ", "\\\\s");
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario);
        }

        String feature = BuildConfig.TEST_FEATURE;
        if (!feature.isEmpty()) {
            bundle.putString(CUCUMBER_FEATURE_KEY, feature);
        }

        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
