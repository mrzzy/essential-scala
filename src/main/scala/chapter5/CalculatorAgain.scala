/*
 * essential-scala
 * exercise 5.6.6.2 Calculator Again
 */

package chapter5

import CovariantSum._

sealed trait Expression {
  type Result = Sum[String, Double]
  // evaluates expression to a sum / union type of either:
  // - message string stating the error that occured during the evaluation
  // - result of evaluating the expression as a double value.
  def eval: Result = {
    this match {
      case Addition(left, right) =>
        binEval(left, right, (x: Double, y: Double) => Success(x + y))
      case Subtraction(left, right) =>
        binEval(left, right, (x: Double, y: Double) => Success(x - y))
      case Division(left, right) =>
        binEval(
          left,
          right,
          (x: Double, y: Double) =>
            if (y == 0.0) Failure("Division by zero is undefined.")
            else Success(x / y)
        )
      case SquareRoot(value) =>
        value.eval.flatMap { v =>
          {
            if (v <= 0) Failure("Square root of a no. < 0 is irrational.")
            else Success(Math.sqrt(v))
          }
        }
      case Number(value) => Success(value)
    }
  }

  // evaluates a given binary operation using the given left & right expressions
  def binEval(
      left: Expression,
      right: Expression,
      binOp: (Double, Double) => Result
  ): Result = {
    left.eval.flatMap { leftValue =>
      right.eval.flatMap { rightValue =>
        binOp(leftValue, rightValue)
      }
    }
  }
}
final case class Addition(left: Expression, right: Expression)
    extends Expression
final case class Subtraction(left: Expression, right: Expression)
    extends Expression
final case class Division(left: Expression, right: Expression)
    extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
