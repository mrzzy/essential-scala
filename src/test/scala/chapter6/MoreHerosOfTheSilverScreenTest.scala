/*
 * essential-scala
 * exercise 6.3.1 (More) Heroes of the Silver Screen
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import IntranetMovieDatabase._
import MoreHerosOfTheSilverScreen._

class MoreHerosOfTheSilverScreenTest extends AnyFlatSpec {
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

  "filmNames" should "contain all films by any director in any order" in {
    assert(
      filmNames.toSet subsetOf Set(
        memento.name,
        darkKnight.name,
        inception.name,
        highPlainsDrifter.name,
        outlawJoseyWales.name,
        unforgiven.name,
        granTorino.name,
        invictus.name,
        predator.name,
        dieHard.name,
        huntForRedOctober.name,
        thomasCrownAffair.name
      )
    )
  }

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

}
