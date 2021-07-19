/*
 * essential-scala
 * exercise 2.4.5.1: Cat-o-matique test
*/

package chapter2
import org.scalatest.flatspec.AnyFlatSpec

class CatOMatiqueTest extends AnyFlatSpec {
  behavior of "CatOMatique"

  "Oswald" should "have correct attributes" in {
    assert(CatOMatique.Oswald.color == "Black")
    assert(CatOMatique.Oswald.food == "Milk")
  }

  "Henderson" should "have correct attributes" in {
    assert(CatOMatique.Henderson.color == "Ginger")
    assert(CatOMatique.Henderson.food == "Chip")
  }

  "Quentin" should "have correct attributes" in {
    assert(CatOMatique.Quentin.color == "Tabby and white")
    assert(CatOMatique.Quentin.food == "Curry")
  }
}
