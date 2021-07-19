/*
 * essential-scala
 * exercise 3.1.6.1: Cats, Again
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class CatsAgainTest extends AnyFlatSpec {
  behavior of "CatsAgain"

  it should "contain data of 3 cats" in {
    val expectedCats = List(
      ("Oswald", "Black", "Milk"),
      ("Henderson", "Ginger", "Chips"),
      ("Quentin", "Tabby and white", "Curry")
    ).map(c =>  new Cat(c._1, c._2, c._3))

    // check that CatOMatique contains the data of all 3 cats
    assert(expectedCats.map(
      CatsAgain.cats.contains(_)
    ).fold(true)(_ && _))
  }
}

