/*
 * essential-scala
 * exercise 4.2.2.3 A Short Division Exercise
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class AShortDivisionExerciseTest extends AnyFlatSpec {
  behavior of "divide"

  it should "return Finite DivisionResult if valid division" in {
    assert(divide(1, 2) == Finite(0))
  }

  it should "return Infinite DivisionResult if valid division" in {
    assert(divide(2, 0) == Infinite())
  }
}
