Feature: Movie Details

  Background:
    Given the following remote movie details exist
      | movieId | posterPath   | title     | description               | releaseDate |
      | 100     | deadpool.jpg | Deadpool  | awesome movie             | 2000-01-01  |
      | 200     | xmen.jpg     | X-Men     | wolverine rocks           | 2010-05-03  |
      | 300     | starwars.jpg | Star Wars | may the force be with you | 2008-03-04  |

   Scenario: Show release date of a movie
     When Launch details screen for movie with id 100
     Then I expect to see the release data "2000-01-01"
