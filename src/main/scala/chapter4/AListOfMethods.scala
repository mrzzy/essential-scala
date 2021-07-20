/*
 * essential-scala
 * exercise 4.6.3.1 A List of Methods
 */

package chapter4

sealed trait IntList {
  def length: Int = {
    this match {
      case End               => 0
      case ListNode(_, tail) => tail.length + 1
    }
  }

  def sum: Int = {
    this match {
      case End                  => 0
      case ListNode(head, tail) => head + tail.product
    }
  }

  def product: Int = {
    this match {
      case End                  => 1
      case ListNode(head, tail) => head * tail.product
    }
  }

  def double: IntList = {
    this match {
      case End => End
      case ListNode(head, tail) => {
        ListNode(head * 2, tail.double)
      }
    }
  }
}
case object End extends IntList
final case class ListNode(head: Int, tail: IntList) extends IntList
