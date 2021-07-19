/*
 * essential-scala
 * exercise 3.5.3.2 Get Off My Lawn!
*/

package chapter3;

import org.scalatest.flatspec.AnyFlatSpec

class GetOffMyLawnTest extends AnyFlatSpec {
  behavior of "Dad"

  it should "rate Clint Eastwood movies a 10" in {
    val eastwood = CaseDirector("Clint", "Eastwood", 1930)
    val invictus = CaseFilm("Invictus", 2009, 7.4, eastwood)
    assert(Dad.rate(invictus) == 10.0)
  }

  it should "rate John McTiernan movies a 7.0" in {
    val mcTiernan = CaseDirector("John", "McTiernan", 1951)
    val dieHard   = CaseFilm("Die Hard", 1988, 8.3, mcTiernan)
    assert(Dad.rate(dieHard) == 7.0)
  }

  it should "rate Chirstopher Nolan movies a 3.0" in {
    val nolan     = CaseDirector("Christopher", "Nolan", 1970)
    val inception = CaseFilm("Inception", 2010, 8.8, nolan)
    assert(Dad.rate(inception) == 3.0)
  }
}
