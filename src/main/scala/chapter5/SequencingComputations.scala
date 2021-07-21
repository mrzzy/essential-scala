/*
 * essential-scala
 * exercise 5.5.4.3 Sequencing Computations
 */

package chapter5

object SequencingComputations {
  // return a List[Int] containing both all the elements and their negation.
  // Order is not important.
  def echoNegate(elements: List[Int]): List[Int] =
    elements.flatMap((x: Int) => List(x, -x))

  // return a List[Maybe[Int]] containing None for the odd elements.
  def nullifyOdd(elements: List[Maybe[Int]]): List[Maybe[Int]] =
    elements.map(maybe =>
      maybe.flatMap { x => if (x % 2 == 0) Full(x) else Empty() }
    )
}
