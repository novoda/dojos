Feature: Stream shows Posters

  Background: The following movies are displayed
    Given the following remote movie posters exist
      | movieId | posterPath   |
      | 100     | deadpool.jpg |
      | 200     | xmen.jpg     |
      | 300     | starwars.jpg |

  Scenario: A poster is displayed for a given movie
    When movies are shown
    Then Poster "deadpool.jpg" is displayed at position 0
