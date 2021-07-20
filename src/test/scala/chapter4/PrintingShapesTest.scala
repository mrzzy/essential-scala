/*
 * essential-scala
 * exercise 4.2.2.1 Printing Shapes
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class PrintingShapesTest extends AnyFlatSpec {
  behavior of "Draw"

  it should "return description of Circle" in {
    assert(Draw(Circle(10, Red())) == "A red circle of radius 10.0cm")
  }

  it should "return description of Rectangle" in {
    assert(
      Draw(
        Rectangle(4, 3, Yellow())
      ) == "A yellow rectangle of width 3.0cm and length 4.0cm"
    )
  }

  it should "return description of Square" in {
    assert(Draw(Square(2, Pink())) == "A pink square of length 2.0cm")
  }
}
