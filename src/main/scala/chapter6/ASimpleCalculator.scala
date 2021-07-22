/*
 * essential-scala
 * exercise 6.5.1.4 A Simple Calculator
 */

package chapter6

object ASimpleCalculator {
  def eval(operator: String)(left: Int, right: Int): Option[Int] = {
    operator match {
      case "+"               => Some(left + right)
      case "-"               => Some(left - right)
      case "*"               => Some(left * right)
      case "/" if right == 0 => None // divisionm by zero
      case "/"               => Some(left / right)
      case _                 => None // invalid operator
    }
  }

  def calculator(operand1: String, operator: String, operand2: String): Unit = {
    val resultOption = for {
      int1 <- operand1.toIntOption
      int2 <- operand2.toIntOption
      result <- eval(operator)(int1, int2)
    } yield result

    resultOption match {
      case Some(result) => println(s"Result: $result")
      case None         => println("Failed to evaluate due to error")
    }
  }
}
