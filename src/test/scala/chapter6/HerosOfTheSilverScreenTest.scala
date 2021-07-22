/*
 * essential-scala
 * exercise 6.2.7.1 Heroes of the Silver Screen test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import IntranetMovieDatabase._
import HerosOfTheSilverScreen._

class HerosOfTheSilverScreenTest extends AnyFlatSpec {
  behavior of "HerosOfTheSilverScreen"

  "nolanFilms" should "contain all nolan films in any order" in {
    assert(
      nolanFilms.toSet subsetOf Set(
        inception.name,
        darkKnight.name,
        memento.name
      )
    )
  }

  "films" should "contain all films by any director in any order" in {
    assert(
      films.toSet subsetOf Set(
        memento,
        darkKnight,
        inception,
        highPlainsDrifter,
        outlawJoseyWales,
        unforgiven,
        granTorino,
        invictus,
        predator,
        dieHard,
        huntForRedOctober,
        thomasCrownAffair
      )
    )
  }

  "earliestMcTiernanDate" should "be the year of release of earliest McTiernan film" in
    assert(earliestMcTiernanDate == predator.yearOfRelease)

  "ratedFilms" should "contain all films sorted by imdbRating in descending order" in {
    assert(
      ratedFilms == Seq(
        darkKnight,
        inception,
        memento,
        unforgiven,
        dieHard,
        granTorino,
        outlawJoseyWales,
        predator,
        highPlainsDrifter,
        huntForRedOctober,
        invictus,
        thomasCrownAffair
      )
    )
  }

  "averageRating" should "contain the average rating of all films" in {
    assert(Math.abs(averageRating - 8.033333333333333) < 0.00000000001)
  }

  "directorEarliestFilms" should "contain the earliest film by any director" in {
    assert(earliestFilm == highPlainsDrifter)
  }
}
