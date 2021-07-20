/*
 * essential-scala
 * exercise 4.7.0.1 A Calculator
 */

package chapter4

package ACalculator {
  // result represents possible results of a computation
  sealed trait Result
  final case class Success(value: Double) extends Result
  final case class Failure(message: String) extends Result

  // computation defines an AST for defining numeric computation
  sealed trait Computation {
    def eval: Result = {
      this match {
        case Constant(value) => Success(value)
        case op: BinaryOp    => op.eval
        case SquareRoot(comp) =>
          comp.eval match {
            case Failure(message) => Failure(message)
            case Success(value) => {
              if (value <= 0.0) {
                Failure("Square root of a negative number is irrational")
              } else Success(Math.sqrt(value))

            }
          }
      }
    }
  }
  final case class SquareRoot(comp: Computation) extends Computation
  final case class Constant(value: Double) extends Computation

  // binaryOp is a specialisation of a computation with 2 operands
  sealed trait BinaryOp extends Computation {
    def left: Computation
    def right: Computation

    override def eval: Result = {
      (left.eval, right.eval) match {
        case (Failure(leftMessage), Failure(rightMessage)) =>
          Failure(s"$leftMessage. $rightMessage")
        case (Failure(message), _) => Failure(message)
        case (_, Failure(message)) => Failure(message)
        case (Success(leftValue), Success(rightValue)) =>
          perform(leftValue, rightValue)
      }
    }

    def perform(left: Double, right: Double): Result = {
      this match {
        case Addition(_, _)    => Success(left + right)
        case Subtraction(_, _) => Success(left - right)
        case Division(_, _) =>
          if (right == 0) {
            Failure("Division by zero is undefined")
          } else Success(left / right)
      }
    }
  }
  final case class Addition(left: Computation, right: Computation)
      extends BinaryOp
  final case class Subtraction(left: Computation, right: Computation)
      extends BinaryOp
  final case class Division(left: Computation, right: Computation)
      extends BinaryOp
}
