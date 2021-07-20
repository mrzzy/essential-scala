/*
 * essential-scala
 * exercise 2.4.5.3: Precise Square Dance! test
 */

package chapter2

import org.scalatest.flatspec.AnyFlatSpec

class PreciseSquareDanceTest extends AnyFlatSpec {
  behavior of "PreciseSquareDance.calc"

  it should "compute the square of given Double x" in {
    assert(PreciseSquareDance.calc.square(2.4) == 2.4 * 2.4)
  }

  it should "compute the square of given Int x" in {
    assert(PreciseSquareDance.calc.square(2) == 2 * 2)
  }
}
