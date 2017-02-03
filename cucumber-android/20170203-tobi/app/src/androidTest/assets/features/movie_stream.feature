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
    Then I expect to see  the following movie poster
      | path   | pos   |
      | <path> | <pos> |


    Examples:
      | path         | pos |
      | deadpool.jpg | 0   |
      | xmen.jpg     | 1   |
      | starwars.jpg | 2   |
