/*
 * essential-scala
 * exercise 3.3.2.1 Friendly Person Factory
 */

package chapter3

class Person(val firstName: String, val lastName: String)

object Person {
  def apply(fullName: String) = {
    val Array(firstName, lastName) = fullName.split(" ")
    new Person(firstName, lastName)
  }
}
