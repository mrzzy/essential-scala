/*
 * essential-scala
 * exercise 4.6.3.1 A List of Methods test
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class AListOfMethodsTest extends AnyFlatSpec {
  behavior of "IntList"

  // test cases copied from the exercise description
  val example = ListNode(1, ListNode(2, ListNode(3, End)))
  ".length" should "return the length of the int list" in {
    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End.length == 0)
  }

  ".product" should "compute & return the product of elements in the list" in {
    assert(example.product == 6)
    assert(example.tail.product == 6)
    assert(End.product == 1)
  }

  ".double" should "compute IntList with its elements doubled (2x)" in {
    assert(example.double == ListNode(2, ListNode(4, ListNode(6, End))))
    assert(example.tail.double == ListNode(4, ListNode(6, End)))
    assert(End.double == End)
  }
}
