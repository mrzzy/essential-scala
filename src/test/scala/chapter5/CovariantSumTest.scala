/*
 * essential-scala
 * exercisesa tests
 * - 5.6.4.1 Exercise: Covariant Sum
 * - 5.6.4.2 Exercise: Some sort of flatMap
 * - 5.6.6.2 Calculator Again
 */
package chapter5

import CovariantSum._
import org.scalatest.flatspec.AnyFlatSpec

class CovariantSumTest extends AnyFlatSpec {
  behavior of "Sum"

  it should "Store either Int or String" in {
    assert(Failure[Int](1).value == 1)
    assert(Success[String]("abc").value == "abc")

    val sum: Sum[Int, String] = Success("test")
    assert((sum match {
      case Failure(value) => value.toString
      case Success(value) => value
    }) == "test")
  }

  it should "fold to String either Int or String" in {
    assert(
      Failure[Int](1)
        .fold((i: Int) => i.toString, (s: String) => s) == "1"
    )
    assert(
      Success[String]("abc")
        .fold((i: Int) => i.toString, (s: String) => s) == "abc"
    )
  }

  it should "map if Success case" in {
    val responseMap = (code: Int) => s"The status code is $code"
    assert(
      Failure[String]("Something failed").map(responseMap)
        == Failure[String]("Something failed")
    )

    assert(
      Success[Int](200).map(responseMap)
        == Success[String]("The status code is 200")
    )
  }

  it should "flatMap" in {
    val id = 20
    val query =
      (id: Int) => Failure[String](f"No such entity with id: $id")
    assert(
      Success[Int](id).flatMap(query) ==
        Failure[String](f"No such entity with id: $id")
    )
  }
}
