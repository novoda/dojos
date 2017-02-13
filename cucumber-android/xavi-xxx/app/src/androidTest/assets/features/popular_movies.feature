Feature: Popular Movies

  Background:
    Given the following remote movie posters exist
      | movieId | posterPath   |
      | 100     | deadpool.jpg |
      | 200     | xmen.jpg     |
      | 300     | starwars.jpg |

  Scenario: Poster for "movieId" is displayed
    Given I open popular movies
    Then I expect to see the poster path "deadpool.jpg" for item 0 in the list

  Scenario: Tapping on movie navigates to movie details
    Given I open popular movies
    When I tap on movie at position 0
    Then I expect to see the movie details
