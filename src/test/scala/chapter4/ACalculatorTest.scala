/*
 * essential-scala
 * exercise 4.7.0.1 A Calculator test
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec
import chapter4.ACalculator._

class ACalculatorTest extends AnyFlatSpec {
  behavior of "ACalculator"

  it should "evaluate valid Computations to Success value" in {
    assert(
      Addition(
        SquareRoot(Constant(4)),
        Subtraction(Division(Constant(14), Constant(2)), Constant(4))
      ).eval == Success(5.0)
    )
  }

  it should "return Failure on division by zero" in {
    assert(
      Division(Constant(1), Constant(0)).eval == Failure(
        "Division by zero is undefined"
      )
    )
  }

  it should "return Failure on squareroot of negative value" in {
    assert(
      SquareRoot(Constant(-3)).eval == Failure(
        "Square root of a negative number is irrational"
      )
    )
  }

  it should "bubble up Failures" in {
    assert(
      Addition(
        SquareRoot(
          Constant(-3)
        ),
        Constant(1)
      ).eval == Failure("Square root of a negative number is irrational")
    )
  }

  it should "combine multiple failures" in {
    assert(
      Addition(
        SquareRoot(
          Constant(-3)
        ),
        Division(Constant(1), Constant(0))
      ).eval == Failure(
        "Square root of a negative number is irrational. " +
          "Division by zero is undefined"
      )
    )
  }
}
