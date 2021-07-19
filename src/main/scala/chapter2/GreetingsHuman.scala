/*
 * essential-scala
 * exercise 2.4.5.5: Geetings, Human!
*/

package chapter2

object person {
  val firstName = "John"
  val lastName = "wick"
}

object alien {
  def greet(p: person.type) = s"Geetings, ${p.firstName}!"

};
