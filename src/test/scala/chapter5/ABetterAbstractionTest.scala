/*
 * essential-scala
 * exercise 5.2.3.1 A Better Abstraction test
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec

class AListOfMethodsTest extends AnyFlatSpec {
  behavior of "IntList"

  // test cases copied from the exercise description
  val example = IntNode(1, IntNode(2, IntNode(3, IntEnd)))
  ".length" should "return the length of the int list" in {
    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(IntEnd.length == 0)
  }

  ".product" should "compute & return the product of elements in the list" in {
    assert(example.product == 6)
    assert(example.tail.product == 6)
    assert(IntEnd.product == 1)
  }

  ".double" should "compute IntList with its elements doubled (2x)" in {
    assert(example.double == IntNode(2, IntNode(4, IntNode(6, IntEnd))))
    assert(example.tail.double == IntNode(4, IntNode(6, IntEnd)))
    assert(IntEnd.double == IntEnd)
  }
}
