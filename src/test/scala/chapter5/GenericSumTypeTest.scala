/*
 * essential-scala
 * exercises tests:
 * - 5.4.3.1: Generic Sum Type
 * - 5.4.6.3 Folding Sum
 * - 5.5.4.4 Sum
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec
import Sum._

class GenericSumTypeTest extends AnyFlatSpec {
  behavior of "Sum"

  it should "Store either Int or String" in {
    assert(Failure[Int, String](1).value == 1)
    assert(Success[Int, String]("abc").value == "abc")

    val sum: Sum[Int, String] = Success("test")
    assert((sum match {
      case Failure(value) => value.toString
      case Success(value) => value
    }) == "test")
  }

  it should "fold to String either Int or String" in {
    assert(
      Failure[Int, String](1)
        .fold((i: Int) => i.toString, (s: String) => s) == "1"
    )
    assert(
      Success[Int, String]("abc")
        .fold((i: Int) => i.toString, (s: String) => s) == "abc"
    )
  }

  it should "map if Success case" in {
    val responseMap = (code: Int) => s"The status code is $code"
    assert(
      Failure[String, Int]("Something failed").map(responseMap)
        == Failure[String, Int]("Something failed")
    )

    assert(
      Success[String, Int](200).map(responseMap)
        == Success[String, String]("The status code is 200")
    )
  }

  it should "flatMap" in {
    val id = 20
    val query =
      (id: Int) => Failure[String, Int](f"No such entity with id: $id")
    assert(
      Success[String, Int](id).flatMap(query) ==
        Failure[String, Int](f"No such entity with id: $id")
    )
  }

}
