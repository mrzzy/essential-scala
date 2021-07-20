/*
 * essential-scala
 * exercise 4.2.2.2 The Color and the Shape
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class TheColorAndTheShapeTest extends AnyFlatSpec {
  behavior of "TheColorAndTheShape"

  "Color" should "determine if a color is light or dark" in {
    assert(Red().brightness == "dark")
    assert(Pink().brightness == "light")
  }
}
