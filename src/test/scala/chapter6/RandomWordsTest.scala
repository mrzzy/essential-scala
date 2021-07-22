/*
 * essential-scala
 * exercise 6.10.1 Random Words test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import RandomWords._

class RandomWordsTest extends AnyFlatSpec {
  behavior of "RandomWords"

  "getAll" should "generate all permuatations of subject verb objects" in {
    assert(
      getAll().length == Seq(subjects, objects, verbs).map(_.length).product
    )
  }

  "getConditional" should "generate conditional model of subject verb objects" in {
    getConditional(subjects)
  }
}
