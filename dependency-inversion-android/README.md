# Dependency Inversion

Throughout this exercise YOU CANNOT CHANGE THE IMPLEMENTATIONS OF InternetFruitRepository or Preferences! However, you can make them implement interfaces.

Go to the `CachingFruitFetcherTests`. First try to write the three tests without touching the current code. Hard, right?

Now use [dependency inversion](http://deviq.com/dependency-inversion-principle/) on the _dependencies_ of the `fetchFruit()` method (there are two). Now can you write the tests?

Currently these are integration tests. What do they integrate with, and how can you make this test a simple unit test?

[Here](https://docs.google.com/presentation/d/1hj7KrMUBIIR9Oy3T-o5q6OEkMO6jN2XqKp75JZph0-E/edit?usp=sharing) are the slides that go with this kata
