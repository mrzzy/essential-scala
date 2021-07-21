/*
 * essential-scala
 * exercises:
 * - 5.1.3.1 Generic List
 * - 5.1.3.2 Working With Generic Types
 * - 5.5.4.1 Mapping Lists
 */

package chapter5

// defines the result of indexing a linked lsit
sealed trait IndexResult[T]
final case class Success[T](value: T) extends IndexResult[T]
final case class Failure[T](message: String) extends IndexResult[T]

sealed trait LinkedList[T] {
  def length: Int = {
    this match {
      case End()         => 0
      case Node(_, tail) => 1 + tail.length
    }
  }

  def contains(element: T): Boolean = {
    this match {
      case End()            => false
      case Node(head, tail) => head == element || tail.contains(element)
    }
  }

  def apply(idx: Int): IndexResult[T] = {
    val outOfBounds = "Index out of bounds"
    if (idx < 0) Failure(outOfBounds)
    else
      this match {
        case End()                        => Failure(outOfBounds)
        case Node(head, tail) if idx == 0 => Success(head)
        case Node(head, tail)             => tail.apply(idx - 1)
      }
  }

  def map[R](f: T => R): LinkedList[R] = {
    this match {
      case End()            => End[R]()
      case Node(head, tail) => Node(f(head), tail.map(f))
    }
  }
}
final case class End[T]() extends LinkedList[T]
final case class Node[T](head: T, tail: LinkedList[T]) extends LinkedList[T]
