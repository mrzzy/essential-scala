/*
 * essential-scala
 * exercise 5.3.4.1 Tree test
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec

class TreeTest extends AnyFlatSpec {
  behavior of "Tree"

  it should "Fold elements into a string" in {
    val tree: Tree[String] =
      TreeNode(
        TreeNode(Leaf("To"), Leaf("iterate")),
        TreeNode(
          TreeNode(Leaf("is"), Leaf("human,")),
          TreeNode(Leaf("to"), TreeNode(Leaf("recurse"), Leaf("divine")))
        )
      )

    assert(
      tree.fold(
        "",
        (head, end: String) => head + end,
        (leftStr: String, rightStr: String) => leftStr + " " + rightStr
      ) == "To iterate is human, to recurse divine"
    )
  }
}
