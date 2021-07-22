/*
 * essential-scala
 * exercise 6.1.9.3 Intranet Movie Database test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import IntranetMovieDatabase._

class IntranetMovieDatabaseTest extends AnyFlatSpec {
  behavior of "IntranetMovieDatabase"

  it should "find directors how have directed more than given no. of films" in {
    assert(Set(eastwood, mcTiernan, nolan) subsetOf filterDirector(0).toSet)
    assert(filterDirector(4).head == eastwood)
  }

  it should "find a director who was born before given year" in {
    assert(findDirectorYOBBefore(1931) == Some(eastwood))
    assert(findDirectorYOBBefore(1951) == Some(eastwood))
  }

  it should "return a list of directors who were born before year who have also directed more than than numberOfFilms" in {
    assert(filterDirector(1931, 4) == List(eastwood))
  }

  it should "Sort the directors by age in the specified order" in {
    assert(sortDirector() == Seq(someGuy, nolan, mcTiernan, eastwood))
    assert(
      sortDirector(false) == Seq(someGuy, nolan, mcTiernan, eastwood).reverse
    )
  }
}
