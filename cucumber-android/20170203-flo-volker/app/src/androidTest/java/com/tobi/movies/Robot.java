package com.tobi.movies;

import android.support.annotation.IdRes;
import android.support.test.espresso.contrib.RecyclerViewActions;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public abstract class Robot<T extends Robot> {

    protected T checkTextIsDisplayed(String text, @IdRes int view) {
        onView(allOf(withId(view), withText(text))).check(matches(isDisplayed()));
        return (T) this;
    }

    protected T selectPositionInRecyclerView(int position, @IdRes int recyclerView) {
        onView(withId(recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
        return (T) this;
    }

    public <K> K toRobot(Class<K> robotClass) throws IllegalAccessException, InstantiationException {
        return robotClass.newInstance();
    }
}
