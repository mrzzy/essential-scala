/*
 * essential-scala
 * exercise 5.5.4.3 Sequencing Computations test
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec
import SequencingComputations._

class SequencingComputationsTest extends AnyFlatSpec {
  behavior of "SequencingComputations"

  "echoNegate()" should "return both elements and negation as a list" in {
    assert(echoNegate(List(1, 2, 3)) == List(1, -1, 2, -2, 3, -3))
  }

  "nullifyOdd()" should "return elements with odd items set to null" in {
    val list: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))
    assert(nullifyOdd(list) == List(Empty[Int](), Full(2), Empty[Int]()))
  }
}
