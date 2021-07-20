/*
 * essential-scala
 * exercise 4.6.3.2 The Forest of Trees test
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class TheForestOfTreesTest extends AnyFlatSpec {
  behavior of "TheForestOfTrees"

  "PatternMatching.Node" should "compute & return sum of elements" in {
    assert(
      PatternMatching
        .Tree(
          PatternMatching.Tree(
            PatternMatching.Leaf(2),
            PatternMatching.Leaf(1)
          ),
          PatternMatching.Tree(
            PatternMatching.Leaf(7),
            PatternMatching.Leaf(0)
          )
        )
        .sum == 10
    )
  }

  "PatternMatching.Node" should "double each element in node" in {
    assert(
      PatternMatching
        .Tree(
          PatternMatching.Tree(
            PatternMatching.Leaf(2),
            PatternMatching.Leaf(1)
          ),
          PatternMatching.Tree(
            PatternMatching.Leaf(7),
            PatternMatching.Leaf(0)
          )
        )
        .double ==
        PatternMatching
          .Tree(
            PatternMatching.Tree(
              PatternMatching.Leaf(4),
              PatternMatching.Leaf(2)
            ),
            PatternMatching.Tree(
              PatternMatching.Leaf(14),
              PatternMatching.Leaf(0)
            )
          )
    )
  }

  "Polymorphic.Node" should "compute & return sum of elements" in {
    assert(
      Polymorphic
        .Tree(
          Polymorphic.Tree(
            Polymorphic.Leaf(2),
            Polymorphic.Leaf(1)
          ),
          Polymorphic.Tree(
            Polymorphic.Leaf(7),
            Polymorphic.Leaf(0)
          )
        )
        .sum == 10
    )
  }

  "Polymorphic.Node" should "double each element in node" in {
    assert(
      Polymorphic
        .Tree(
          Polymorphic.Tree(
            Polymorphic.Leaf(2),
            Polymorphic.Leaf(1)
          ),
          Polymorphic.Tree(
            Polymorphic.Leaf(7),
            Polymorphic.Leaf(0)
          )
        )
        .double ==
        Polymorphic
          .Tree(
            Polymorphic.Tree(
              Polymorphic.Leaf(4),
              Polymorphic.Leaf(2)
            ),
            Polymorphic.Tree(
              Polymorphic.Leaf(14),
              Polymorphic.Leaf(0)
            )
          )
    )
  }

}
