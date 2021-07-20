/*
 * essential-scala
 * exercise 4.1.4.2 Shaping Up With Traits & 4.1.4.3 Shaping Up 2 (Da Streets)
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class ShapingUpWithTraitsTest extends AnyFlatSpec {
  behavior of "ShapingUpWithTraits"

  "Circle" should "compute area & perimeter" in {
    assert(Circle(4).area == Math.pow(4 * Math.PI, 2))
    assert(Circle(4).perimeter == 2 * 4 * Math.PI)
  }

  "Rectangle" should "compute area & perimeter" in {
    assert(Rectangle(4, 2).area == 4 * 2)
    assert(Rectangle(4, 3).perimeter == 2 * 4 + 2 * 3)
  }

  "Square" should "compute area & perimeter" in {
    assert(Square(4).area == 4 * 4)
    assert(Square(6).perimeter == 4 * 6)
  }
}
