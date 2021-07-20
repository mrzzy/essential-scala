/*
 * essential-scala
 * exercise 4.2.2.3 A Short Division Exercise
 */

package chapter4

sealed trait DivisionResult
final case class Finite(value: Int) extends DivisionResult
final case class Infinite() extends DivisionResult

object divide {
  def apply(x: Int, y: Int): DivisionResult =
    if (y == 0) Infinite() else Finite(x / y)
}
