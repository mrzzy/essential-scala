/*
 * essential-scala
 * exercise 3.1.6.2 Cats on the Prowl
 */

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class ChipShipTest extends AnyFlatSpec {
  behavior of "ChipShip"

  "willService" should "return true if cats favorite food is chips" in {
    // Oswald's favorite food is not chips
    assert(ChipShip.willService(CatsAgain.cats(0)) == false)
    // Henderson's favorite food is chips
    assert(ChipShip.willService(CatsAgain.cats(1)) == true)
  }
}
