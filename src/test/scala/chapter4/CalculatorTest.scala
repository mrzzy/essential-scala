/*
 * essential-scala
 * exercise tests:
 * - 4.4.4.2 Calculator
 * - 4.5.6.2 Calculation
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class CalculatorTest extends AnyFlatSpec {
  behavior of "Calculator"

  "+" should "add a Calculation and an Int" in {
    for (result <- List(Success(2), Failure("Badness")); i <- List(3, 7)) {
      val expected = result match {
        // add to successful calculation should work
        case Success(v) => Success(v + i)
        // add to failed calculation return same failure result
        case Failure(message) => Failure(message)
      }
      assert(Calculator.+(result, i) == expected)
    }
  }

  "-" should "subtract a Calculation by an Int" in {
    for (
      result <- List(Success(2), Failure("Divide by zero")); i <- List(3, 7)
    ) {
      val expected = result match {
        // add to successful calculation should work
        case Success(v) => Success(v - i)
        // add to failed calculation return same failure result
        case Failure(message) => Failure(message)
      }
      assert(Calculator.-(result, i) == expected)
    }
  }

  "/" should "divide a Calculation by an Int" in {
    // test cases derieved from exercise descriptiof
    assert(Calculator./(Success(4), 2) == Success(2))
    assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
    assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
  }
}
