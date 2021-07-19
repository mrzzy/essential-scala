/*
 * essential-scala
 * exercise 3.3.2.1 Friendly Person Factory
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class FriendlyPersonFactoryTest extends AnyFlatSpec {
  behavior of "Person"

  it should "create Person with full name" in {
    val john = Person("John Wick")
    assert(john.firstName == "John" && john.lastName == "Wick")
  }
}
