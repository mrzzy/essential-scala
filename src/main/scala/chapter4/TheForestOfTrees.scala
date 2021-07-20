/*
 * essential-scala
 * exercise 4.6.3.2 The Forest of Trees
 */

package chapter4

package PatternMatching {
  // pattern matching implementation of .sum / .double
  sealed trait Node {
    def sum: Int = {
      this match {
        case Leaf(element)     => element
        case Tree(left, right) => left.sum + right.sum
      }
    }
    def double: Node = {
      this match {
        case Leaf(element)     => Leaf(2 * element)
        case Tree(left, right) => Tree(left.double, right.double)
      }
    }
  }
  final case class Tree(left: Node, right: Node) extends Node
  final case class Leaf(element: Int) extends Node
}

package Polymorphic {
  sealed trait Node {
    def sum: Int
    def double: Node
  }

  final case class Tree(left: Node, right: Node) extends Node {
    def sum: Int = left.sum + right.sum
    def double: Node = Tree(left.double, right.double)
  }

  final case class Leaf(element: Int) extends Node {
    def sum: Int = element
    def double: Node = Leaf(2 * element)
  }
}
