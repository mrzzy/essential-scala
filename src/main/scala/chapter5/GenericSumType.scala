/*
 * essential-scala
 * exercises:
 * - 5.4.3.1: Generic Sum Type
 * - 5.4.6.3 Folding Sum
 * - 5.5.4.4 Sum
 */

package chapter5

package Sum {
  // union type that can store values of type either A or B
  sealed trait Sum[A, B] {
    def fold[C](fAC: A => C, fBC: (B) => C): C = {
      this match {
        case Failure(value) => fAC(value)
        case Success(value) => fBC(value)
      }
    }

    def map[C](f: B => C): Sum[A, C] = {
      this match {
        case Failure(value) => Failure(value)
        case Success(value) => Success(f(value))
      }
    }

    def flatMap[C](f: B => Sum[A, C]): Sum[A, C] = {
      this match {
        case Failure(value) => Failure(value)
        case Success(value) => f(value)
      }
    }
  }
  final case class Failure[A, B](value: A) extends Sum[A, B]
  final case class Success[A, B](value: B) extends Sum[A, B]
}
