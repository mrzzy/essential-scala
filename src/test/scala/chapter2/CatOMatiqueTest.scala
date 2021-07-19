/*
 * essential-scala
 * exercise 2.4.5.1: Cat-o-matique test
*/

package chapter2
import org.scalatest.flatspec.AnyFlatSpec

class CatOMatiqueTest extends AnyFlatSpec {
  behavior of "CatOMatique"

  it should "contain data of 3 cats" in {
    val expectedCats = List(
      ("Oswald", "Black", "Milk"),
      ("Henderson", "Ginger", "Chips"),
      ("Quentin", "Tabby and white", "Curry")
    ).map(c =>  new Cat(c._1, c._2, c._3))

    // check that CatOMatique contains the data of all 3 cats
    assert(expectedCats.map(
      CatOMatique.cats.contains(_)
    ).fold(true)(_ && _))
  }
}
