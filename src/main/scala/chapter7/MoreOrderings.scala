/*
 * essential-scala
 * exercises:
 * - 7.1.6.1 More Orderings
 * - 7.1.6.2 Rational Orderings
 */

package chapter7

object MoreOrderings {
  val absOrdering = Ordering.fromLessThan[Int](Math.abs(_) < Math.abs(_))

  // represents a rational number
  final case class Rational(numerator: Int, denominator: Int) {
    def toDouble: Double = numerator.toDouble / denominator
  }
  val rationalOrdering =
    Ordering.fromLessThan[Rational](_.toDouble < _.toDouble)
}
