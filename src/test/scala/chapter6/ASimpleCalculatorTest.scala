/*
 * essential-scala
 * exercise 6.5.1.4 A Simple Calculator test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import ASimpleCalculator.calculator
import java.io.ByteArrayOutputStream
import test.TestUtil._

class ASimpleCalculatorTest extends AnyFlatSpec {
  behavior of "calculator"

  it should "successfully evaluate valid expressions" in {
    assert(runCaptureOut(() => calculator("6", "*", "2")) == "Result: 12\n")
    assert(runCaptureOut(() => calculator("1", "+", "2")) == "Result: 3\n")
    assert(runCaptureOut(() => calculator("10", "/", "5")) == "Result: 2\n")
    assert(runCaptureOut(() => calculator("23", "-", "25")) == "Result: -2\n")
  }

  it should "error on invalid expressions" in {
    val message = "Failed to evaluate due to error\n"
    assert(runCaptureOut(() => calculator("NaN", "*", "2")) == message)
    assert(runCaptureOut(() => calculator("5", "/", "0")) == message)
    assert(runCaptureOut(() => calculator("5", "^", "3")) == message)
  }
}
