/*
 * essential-scala
 * exercise 2.4.5.5: Geetings, Human! test
*/

package chapter2

import org.scalatest.flatspec.AnyFlatSpec

class GreetingsHumanTest extends AnyFlatSpec {
  behavior of "GreetingsHuman"

  it should "greet person" in {
    assert(alien.greet(person) == s"Geetings, ${person.firstName}!");
  }
}
