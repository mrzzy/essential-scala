/*
 * essential-scala
 * exercises:
 * - 6.2.7.2 Do-It-Yourself
 * - 6.8.4 Do-It-Yourself Part 2
 */

package chapter6

object DoItYourself {
  // Write a method to find the smallest element of a Seq[Int].
  def min(ints: Seq[Int]) = ints.fold(Int.MaxValue) { (int, otherInt) =>
    Math.min(int, otherInt)
  }

  // create the sequence containing each value only once. Order is not important
  def unique[T](values: Seq[T]) = values
    .foldLeft[Set[T]](Set()) { (uniqueValues, value) =>
      if (uniqueValues.contains(value)) uniqueValues else uniqueValues + value
    }
    .toSeq

  // Write map in terms of foldRight
  def map[A, B](values: Seq[A])(f: A => B) = values.flatMap { v => Seq(f(v)) }

  // Write your own implementation of foldLeft that uses foreach and mutable state.
  def foldLeft[A, B](values: Seq[A], z: B)(op: (B, A) => B): B = {
    var accumulator: B = z
    values.foreach { v => accumulator = op(accumulator, v) }
    accumulator
  }

  // Write a method that takes two sets and returns a set containing the union of the elements.
  def union[T](left: Set[T], right: Set[T]): Set[T] = {
    right.foldLeft(left) { (leftSet, r) => leftSet + r }
  }

  // Write a method that unions maps by suming values from conflicting keys together
  def unionMap[K](
      left: Map[K, Int],
      right: Map[K, Int]
  ): Map[K, Int] = {
    right.foldLeft(left) {
      case (leftMap, (unionKey, rightValue)) => {
        val unionValue = leftMap.getOrElse(unionKey, 0) + rightValue
        leftMap + (unionKey -> unionValue)
      }
    }
  }

  // generic version of union map
  def unionMap[K, V](
      left: Map[K, V],
      right: Map[K, V],
      merge: (V, V) => V
  ): Map[K, V] = {
    right.foldLeft(left) {
      case (leftMap, (unionKey, rightValue)) => {
        val unionValue = leftMap.get(unionKey) match {
          case Some(leftValue) => merge(leftValue, rightValue)
          case None            => rightValue
        }
        leftMap + (unionKey -> unionValue)
      }
    }
  }
}
