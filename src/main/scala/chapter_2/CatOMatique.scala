/*
 * essential-scala
 * exercise 2.4.5.1: Cat-o-matique
*/

package co.mrzzy.essentialScala.chapter2;

case class Cat(name: String, color: String, food: String)

object CatOMatique {
  val cats = List(
      new Cat("Oswald", "Black", "Milk"),
      new Cat("Henderson", "Ginger", "Chips"),
      new Cat("Quentin", "Tabby and white", "Curry")
  )
}

