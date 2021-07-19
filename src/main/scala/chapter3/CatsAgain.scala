/*
 * essential-scala
 * exercise 2.4.5.1: Cat-o-matique
 */

package chapter3

// use case class here to automatically provide equals() implementation
case class Cat(name: String, color: String, food: String)

object CatsAgain {
  val cats = List(
    new Cat("Oswald", "Black", "Milk"),
    new Cat("Henderson", "Ginger", "Chips"),
    new Cat("Quentin", "Tabby and white", "Curry")
  )
}
