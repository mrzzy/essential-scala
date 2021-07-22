/*
 * essential-scala
 * exercises tests:
 * - 6.5.1.1 Adding Things
 * - 6.5.1.2 Adding All of the Things
 * - 6.6.2.1 Adding All the Things ++
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import AddingThings._
import scala.util.Try
import scala.util.Success

class AddingThingsTest extends AnyFlatSpec {
  behavior of "AddingThings"

  "addOptions" should "Add two Option[Int] together" in {
    assert(addOptions(Some(1), Some(2)) == Some(3))
    assert(addOptions(None, Some(2)) == None)
    assert(addOptions(None, None) == None)
  }

  "addOptions" should "Add three Option[Int] together" in {
    assert(addOptions(Some(1), Some(2), Some(3)) == Some(6))
  }

  "addTrys" should "Add three Try[Int] together" in {
    assert(addTrys(Try(1), Try(2), Try(3)) == Success(6))
  }

  "addSeqs" should "Add three Seq[Int] together" in {
    assert(addSeqs(Seq(1), Seq(2), Seq(3)) == Seq(6))
  }

  "addOptionsMap" should "Add three Option[Int] together using .map and .flatMap" in {
    assert(addOptionsMap(Some(1), Some(2), Some(3)) == Some(6))
  }
}
