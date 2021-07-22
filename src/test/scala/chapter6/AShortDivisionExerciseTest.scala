/*
 * essential-scala
 * exercise 6.5.1.3 A(nother) Short Division Exercise test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import AShortDivisionExercise._

class AShortDivisionExerciseTest extends AnyFlatSpec {
  behavior of "divide"

  it should "divide 2 ints and return Option[Int] result" in {
    assert(divide(6, 2) == Some(3))
    assert(divide(6, 0) == None)
  }

  it should "divide 2 Option[int]s and return Option[Int] result" in {
    assert(divideOption(Some(6), Some(2)) == Some(3))
    assert(divideOption(Some(6), Some(0)) == None)
  }
}
