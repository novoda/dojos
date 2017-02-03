Feature: Movie Posters

  Background:
    Given the following remote movie posters exist
      | movieId | posterPath   |
      | 100     | deadpool.jpg |
      | 200     | xmen.jpg     |
      | 300     | starwars.jpg |


    @current
   Scenario: Show movie poster
     When Launch poster overview screen
     Then I expect to see movie poster with url "deadpool.jpg" at position 0
