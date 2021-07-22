/*
 * essential-scala
 * exercise 6.3.1 (More) Heroes of the Silver Screen
 */

package chapter6

import IntranetMovieDatabase._

object MoreHerosOfTheSilverScreen {
  // List the names of the films directed by Christopher Nolan.
  val nolanFilms = for (film <- nolan.films) yield film.name

  // List the names of all films by all directors.
  val filmNames = for {
    director <- directors
    film <- director.films
  } yield film.name

  // Find all films sorted by descending IMDB rating:
  val ratedFilms = (for {
    director <- directors
    film <- director.films
  } yield film).sortBy(_.imdbRating)(Ordering.Double.TotalOrdering.reverse)

  // Print the following for every film: "Tonight only! FILM NAME by DIRECTOR!"
  for {
    director <- directors
    film <- director.films
  } println(
    s"Tonight only! ${film.name} by ${director.firstName} ${director.lastName}!"
  )
}
