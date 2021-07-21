/*
 * essential-scala
 * exercise 5.3.4.1 Tree
 */

package chapter5

sealed trait Tree[A] {
  def fold[B](end: B, f: (A, B) => B, merge: (B, B) => B): B = {
    this match {
      case Leaf(value) => f(value, end)
      case TreeNode(left, right) => {
        val leftFolded = left.fold(end, f, merge)
        val rightFolded = right.fold(end, f, merge)
        merge(leftFolded, rightFolded)
      }
    }
  }
}
final case class Leaf[A](value: A) extends Tree[A]
final case class TreeNode[A](left: Tree[A], right: Tree[A]) extends Tree[A]
