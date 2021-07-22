/*
 * essential-scala
 * exercise 6.5.1.3 A(nother) Short Division Exercise
 */

package chapter6

object AShortDivisionExercise {
  def divide(left: Int, right: Int): Option[Int] =
    if (right == 0) None else Some(left / right)

  def divideOption(left: Option[Int], right: Option[Int]): Option[Int] = for {
    l <- left
    r <- right
    d <- divide(l, r)
  } yield d
}
