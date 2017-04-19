# Dependency Inversion

Throughout this exercise YOU CANNOT CHANGE THE IMPLEMENTATIONS OF InternetFruitRepository or Preferences! However, you can make them implement interfaces.

Go to the `CachingFruitFetcherTests`. First try to write the three tests without touching the current code. Hard, right?

Now use dependency inversion on the _dependencies_ of the `fetchFruit()` method (there are two). Now can you write the tests?

Currently these are integration tests. What do they integrate with, and how can you make this test a simple unit test?
