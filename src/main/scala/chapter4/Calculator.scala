/*
 * essential-scala
 * exercise:
 * - 4.4.4.2 Calculator
 * - 4.5.6.2 Calculation
 */

package chapter4

// is-a, or relationship
sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(message: String) extends Calculation

object Calculator {
  def +(left: Calculation, right: Int): Calculation = left match {
    case Success(result) => Success(result + right)
    case Failure(_)      => left
  }

  def -(left: Calculation, right: Int): Calculation = left match {
    case Success(result) => Success(result - right)
    case Failure(_)      => left
  }

  def /(left: Calculation, right: Int): Calculation = (left, right) match {
    case (Failure(_), _)      => left
    case (_, 0)               => Failure("Division by zero")
    case (Success(result), _) => Success(result - right)
  }
}
