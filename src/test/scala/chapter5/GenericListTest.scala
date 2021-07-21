/*
 * essential-scala
 * exercises tests:
 * - 5.1.3.1 Generic List
 * - 5.1.3.2 Working With Generic Types
 * - 5.5.4.1 Mapping Lists
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec

class GenericListTest extends AnyFlatSpec {
  behavior of "LinkedList"

  // test cases derived from exercise description
  it should "Store a list of generic typed values" in {
    val example = Node(1, Node(2, Node(3, End())))
    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End().length == 0)
  }

  it should "Check if element is member of generic list" in {
    val example = Node(1, Node(2, Node(3, End())))
    assert(example.contains(3) == true)
    assert(example.contains(4) == false)
    assert(End().contains(0) == false)
  }

  it should "Index generic list using integer index" in {
    val example = Node(1, Node(2, Node(3, End())))
    assert(example(0) == Success(1))
    assert(example(1) == Success(2))
    assert(example(2) == Success(3))
    assert(example(3) == Failure("Index out of bounds"))
  }

  it should "map and double all the elements in the list" in {
    val list: LinkedList[Int] = Node(1, Node(2, Node(3, End())))
    assert(list.map(_ * 2) == Node(2, Node(4, Node(6, End()))))
    assert(list.map(_ + 1) == Node(2, Node(3, Node(4, End()))))
    assert(list.map(_ / 3) == Node(1 / 3, Node(2 / 3, Node(3 / 3, End()))))
  }
}
