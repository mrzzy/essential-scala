/*
 * essential-scala
 * exercises tests:
 * - 6.2.7.2 Do-It-Yourself
 * - 6.8.4 Do-It-Yourself Part 2
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import DoItYourself._

class DoItYourselfTest extends AnyFlatSpec {
  behavior of "DoItYourself"

  "min" should "compute min of ints" in {
    assert(min((1 to 99).toList) == 1)
  }

  "unique" should "create a unique set of ints from a sequence of ints" in {
    assert(unique(List(1, 1, 2, 4, 3, 4)).toSet subsetOf Set(1, 2, 3, 4))
  }

  "map" should "function the same as built in .map()" in {
    val double: Int => Int = x => x * 2
    val values = Seq(1, 3, 4, 7)
    assert(map(values)(double) == values.map(double))
  }

  "foldLeft" should "function the same as built in .foldLeft()" in {
    val sum: (Int, Int) => Int = (x, y) => x + y
    val values = Seq(1, 3, 4, 7)
    assert(foldLeft(values, 0)(sum) == values.foldLeft(0)(sum))
  }

  "union" should "compute the union of two sets" in {
    val left = Set(1, 2, 3, 4)
    val right = Set(3, 4, 5, 6)
    assert(union(left, right) == left ++ right)
  }

  "unionMap" should "compute the union of two maps" in {
    assert(
      unionMap(Map('a' -> 1, 'b' -> 2), Map('a' -> 2, 'b' -> 4)) == Map(
        'a' -> 3,
        'b' -> 6
      )
    )
  }

  "unionMap" should "compute the generic union of two maps with given merge" in {
    assert(
      unionMap(
        Map('a' -> 2, 'b' -> 4),
        Map('a' -> 1, 'b' -> 2),
        merge = (x: Int, y: Int) => x / y
      ) == Map(
        'a' -> 2,
        'b' -> 2
      )
    )
  }
}
