/*
 * essential-scala
 * exercise 5.6.6.2 Calculator Again
 */

package chapter5
import org.scalatest.flatspec.AnyFlatSpec
import CovariantSum._

class CalculatorAgainTest extends AnyFlatSpec {
  behavior of "Expression"

  // test case derived from exercise description
  it should "evalulate the given expressions" in {
    assert(Addition(Number(1), Number(2)).eval == Success(3))
    assert(
      SquareRoot(Number(-1)).eval == Failure(
        "Square root of a no. < 0 is irrational."
      )
    )
    assert(
      Division(Number(4), Number(0)).eval == Failure(
        "Division by zero is undefined."
      )
    )
    assert(
      Division(
        Addition(Subtraction(Number(8), Number(6)), Number(2)),
        Number(2)
      ).eval == Success(2.0)
    )
  }
}
