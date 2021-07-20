/*
 * essential-scala
 * exercise 3.3.2.1 Friendly Person Factory
 */

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class ApplicationApplicationApplicationTest extends AnyFlatSpec {
  behavior of "CasePerson"

  it should "create Person with full name" in {
    val john = CasePerson("John Wick")
    assert(john.firstName == "John" && john.lastName == "Wick")
  }
}
