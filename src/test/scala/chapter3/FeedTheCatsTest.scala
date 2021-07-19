/*
 * essential-scala
 * exercise 3.5.3.1 Feed the Cats
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class ChipShopTest extends AnyFlatSpec {
  behavior of "ChipShop"

  "willServe" should "return true if cats favorite food is chips" in {
    // Oswald's favorite food is not chips
    assert(ChipShop.willServe(CaseCat("Oswald", "Black", "Milk")) == false)
    // Henderson's favorite food is chips
    assert(ChipShop.willServe(CaseCat("Henderson", "Ginger", "Chips")) == true)
  }
}
