/*
 * essential-scala
 * exercise test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec

class AnimalsTest extends AnyFlatSpec {
  behavior of "Animals"

  it should "prepend 'mouse' and append 'tyrannosaurus'" in {
    assert(
      Animals.moreAnimals == Seq(
        "mouse",
        "cat",
        "dog",
        "penguin",
        "tyrannosaurus"
      )
    )
  }

  it should "determine lowerest common supertype be int and string" in {
    assert(Animals.notJustAnimals.isInstanceOf[Seq[Any]])
  }
}
