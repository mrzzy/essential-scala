/*
 * essential-scala
 * exercise 3.4.5.4 Application, Application, Application
 */

package chapter3

case class CasePerson(firstName: String, lastName: String)

object CasePerson {
  def apply(fullName: String): CasePerson = {
    val Array(firstName, lastName) = fullName.split(" ")
    apply(firstName, lastName)
  }
}
