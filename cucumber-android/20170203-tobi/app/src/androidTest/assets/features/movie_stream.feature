Feature: Movie Posters

  Background:
    Given the following remote movie posters exist
      | movieId | posterPath   |
      | 100     | deadpool.jpg |
      | 200     | xmen.jpg     |
      | 300     | starwars.jpg |

  @current
  Scenario Outline: Show movie poster
    When Launch poster overview screen
    Then I expect to see movie poster with url "<image>" at position <pos>

    Examples:
      | image        | pos |
      | deadpool.jpg | 0   |
      | xmen.jpg     | 1   |
      | starwars.jpg | 2   |
