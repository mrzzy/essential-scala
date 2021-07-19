/*
 * essential-scala
 * exercise 2.4.5.2: Square Dance! test
*/

package chapter2

import org.scalatest.flatspec.AnyFlatSpec

class SquareDanceTest extends AnyFlatSpec  {
  behavior of "SquareDance.calc"

  it should "compute the square of given x" in {
    assert((for(i <- 1 to 20) yield i).forall(
      i => SquareDance.calc.square(i) == i * i
    ))
  }
}
