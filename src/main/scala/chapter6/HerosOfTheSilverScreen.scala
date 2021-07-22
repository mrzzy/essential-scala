/*
 * essential-scala
 * exercise 6.2.7.1 Heroes of the Silver Screen
 */

package chapter6

import IntranetMovieDatabase._

object HerosOfTheSilverScreen {
  // Starting with the definition of nolan, create a list containing the names of the films directed by Christopher Nolan.
  val nolanFilms = nolan.films.map(_.name)
  // Starting with the definition of directors, create a list containing the names of all films by all directors.
  val films = directors.flatMap(_.films)
  // Starting with mcTiernan, find the date of the earliest McTiernan film.
  val earliestMcTiernanDate = mcTiernan.films.foldLeft(Int.MaxValue) {
    (minYear, film) => Math.min(minYear, film.yearOfRelease)
  }
  // Starting with directors, find all films sorted by descending IMDB rating:
  val ratedFilms = directors
    .flatMap(_.films)
    .sortBy(_.imdbRating)(Ordering.Double.TotalOrdering.reverse)

  // Starting with directors again, find the average score across all films:
  val filmRatings = directors
    .flatMap(_.films)
    .map(_.imdbRating)
  val averageRating = filmRatings.sum / filmRatings.length.toDouble

  // Starting with directors, print the following for every film: "Tonight only! FILM NAME by DIRECTOR!"
  directors
    // generate (director, film) pairs
    .flatMap { director => director.films.map((director, _)) }
    .map { case (director, film) =>
      s"Tonight only! ${film.name} by ${director.firstName} ${director.lastName}!"
    }
    .foreach(println)

  // Finally, starting with directors again, find the earliest film by any director:
  val earliestFilm =
    directors.flatMap(_.films).fold(films.head) { (film, otherFilm) =>
      if (film.yearOfRelease < otherFilm.yearOfRelease) film else otherFilm
    }
}
