/*
 * essential-scala
 * exercises:
 * - 5.4.4.1 Maybe that Was a Mistake test
 * - 5.4.6.2 Folding Maybe
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec

class MaybeThatWasAMistakeTest extends AnyFlatSpec {
  behavior of "Maybe"

  it should "Either store nothing (empty) or store an Int (full)" in {
    assert(Empty[Int]() == Empty[Int]())
    assert(Full[Int](1).value == 1)
  }

  it should "Maybe fold and add 3" in {
    val add = (value: Int, end: Int) => value + end
    assert(Full[Int](1).fold(3, add) == 4)
    assert(Empty[Int]().fold(3, add) == 3)
  }

  it should "Maybe map and double" in {
    assert(Full[Int](1).map(_ * 2) == Full(2))
    assert(Empty[Int]().map(_ * 2) == Empty[Int]())
  }

  it should "Maybe flatMap and double" in {
    assert(Full[Int](1).flatMap((i: Int) => Full(i * 2)) == Full(2))
    assert(Empty[Int]().flatMap((i: Int) => Full(i * 2)) == Empty[Int]())
  }
}
