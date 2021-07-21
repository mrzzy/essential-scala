/*
 * essential-scala
 * - 5.4.4.1 Maybe that Was a Mistake test
 * - 5.4.6.2 Folding Maybe
 * - 5.5.4.2 Mapping Maybe
 */

package chapter5

sealed trait Maybe[A] {
  def fold[B](end: B, f: (A, B) => B): B = {
    this match {
      case Full(value) => f(value, end)
      case Empty()     => end
    }
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Full(value) => f(value)
      case Empty()     => Empty[B]()
    }
  }

  def map[B](f: A => B): Maybe[B] = flatMap((a: A) => Full(f(a)))
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]
