/*
 * essential-scala
 * exercises:
 * - 5.6.4.1 Exercise: Covariant Sum
 * - 5.6.4.2 Exercise: Some sort of flatMap
 * - 5.6.6.2 Calculator Again
 */

package chapter5

package CovariantSum {
  sealed trait Sum[+A, +B] {
    def flatMap[C, AA >: A](f: (B) => Sum[AA, C]): Sum[AA, C] = {
      this match {
        case Failure(value) => Failure(value)
        case Success(value) => f(value)
      }
    }

    def map[C](f: B => C): Sum[A, C] = flatMap { b => Success[C](f(b)) }

    def fold[C](fAC: A => C, fBC: B => C) = {
      this match {
        case Failure(value) => fAC(value)
        case Success(value) => fBC(value)
      }
    }
  }
  final case class Failure[A](value: A) extends Sum[A, Nothing]
  final case class Success[B](value: B) extends Sum[Nothing, B]
}
