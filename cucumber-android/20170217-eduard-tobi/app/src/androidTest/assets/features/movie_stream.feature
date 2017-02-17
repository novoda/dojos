Feature: Movie poster

  Background:
    Given the following remote movie posters exist
      | movieId | posterPath   |
      | 100     | deadpool.jpg |
      | 200     | xmen.jpg     |
      | 300     | starwars.jpg |

  @details
  Scenario Outline: Display poster of a movie
    When I show the popular movies screen
    Then I expect to see poster with path "<posterPath>" at position <position>

    Examples:
      | position | posterPath   |
      | 0        | deadpool.jpg |
      | 1        | xmen.jpg     |
      | 2        | starwars.jpg |
