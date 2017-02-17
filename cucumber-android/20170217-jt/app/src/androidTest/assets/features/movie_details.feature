Feature: Movie Details

  Background:
    Given the following remote movie details exist
      | movieId | posterPath   | title     | description               | releaseDate |
      | 100     | deadpool.jpg | Deadpool  | awesome movie             | 2000-01-01  |
      | 200     | xmen.jpg     | X-Men     | wolverine rocks           | 2010-05-03  |
      | 300     | starwars.jpg | Star Wars | may the force be with you | 2008-03-04  |

    Scenario: Release date is show for a movie
      Given
      When I click the movie for id 100
      Then I get the detail screen for movie with release date "2000-01-01"

