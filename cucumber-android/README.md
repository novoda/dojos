# Cucumber + Android Kata

---

## Goal
Get your hands dirty on Cucumber + Android!

## Setup
Install the [Gherkin](https://plugins.jetbrains.com/androidstudio/plugin/7211-gherkin) and Cucumber for Java Plugin in Android Studio.

Fork / Clone this repo

Goto this folder:
`github.com/novoda/dojos/tree/master/cucumber-android`

Make a copy of the folder below (*rename default with a team name*):
`github.com/novoda/dojos/tree/master/cucumber-android/default`

Update the `settings.gradle` file in the root of `dojos` adding your module

run `./gradlew clean build` to ensure you are all set

Rename **secrets.properties.sample** in the app directory of your module to **secrets.properties** and add the **API-Key** from the [wiki](https://github.com/novoda/base/wiki/themoviedb).

Run the application. You should see a grid of movie posters.


---

## Exercise

Your Android team was working hard to build an application which provides information about the latest movies from [themoviedb](https://www.themoviedb.org/documentation/api).

To improve the internal feature documentation they want to migrate their existing Espresso test suite to Cucumber scenarios. The team has done an awesome job so far by decoupling most of the test code from the tests by introducing the testing robots **PopularMoviesRobot** and **PosterDetailsRobot**.

### Display the movie release date besides the description

We first gonna create a failing Cucumber Scenario then implement the feature and make the test pass.  The Scenario should verify that the **release date** of a given movie is displayed in the **MovieDetailsActivity**. 

1. Add a scenario with a meaningful name to **movie_details.feature** 

2. The first step should launch the **MovieDetailsActivity** and takes a **movieId** as step argument. The java implementations of the steps goes to **MovieDetailsSteps**: ```When I show the detail screen for movie with id 1```

3. The next step should verify that the release date is displayed

4. Watch your test fail:
```./gradlew -p cucumber-android/[YOUR_FOLDER]/app connectedCheck -Pcucumber --info```

4. Fix the test by displaying the **MovieDetails#releaseDate** in the **MovieDetailsActivity**. To do so implement the feature and add the needed code to the **PosterDetailsRobot**. Then use the **PosterDetailsRobot** in your step definitions to make the test pass.

*Tips*

- Have a look at the [Cucumber Wiki](https://github.com/cucumber/cucumber/wiki/Feature-Introduction) if you're not sure how a Scenario should look like

- use autocompletion when editing the **feature files**

- [here](http://blog.czeczotka.com/2014/08/17/writing-cucumber-jvm-step-definitions/) you can find some examples how to pass arguments to your step definitions


### Implement the same test without Cucumber

Reuse the code you have added to the **PosterDetailsRobot** in a regular Espresso test. Add this test to **MovieDetailsActivityTest** and see how easily you can share the code between Cucumber and Espresso tests!

### Migrate PopularMoviesActivityTest#shouldShowPoster into a cucumber scenario.

Create a new **feature file** with the name **movie_stream.feature** and a scenario that makes sure the poster of a given movie is displayed. Use **PopularMoviesRobot** in your steps implementations. The step implementations should go to **PopularMoviesSteps**.

*Tips*

- Use [DataTables](http://www.thinkcode.se/blog/2014/06/30/cucumber-data-tables) to pass the DTO's as step arguments as it is done in the **Background** section of **movie_details.feature**

- The assets for movie posters are located in **main/assets**. You can reference them by file name, as it is done in **PopularMoviesActivityTest.POSTER_PATH**

- You can annotate your scenario or the whole feature, for example with **@details** to just run this one using the command-line:

	```./gradlew -p cucumber-android/[YOUR_FOLDER]/app connectedCheck -Pcucumber -Ptags="@details"```



### Create Scenario Outlines 
If there is still time left, change the test you have just written in order to verify that multiple movies are shown in the correct order using [Scenario Outlines](https://github.com/cucumber/cucumber/wiki/Scenario-Outlines).

Ex. Deadpool at position one and X-MEN at position two.
