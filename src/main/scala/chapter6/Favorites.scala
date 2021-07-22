/*
 * essential-scala
 * exercise 6.8.3.1 Favorites
 */

package chapter6

object Favorites {
  // BEGIN code copied from exercise description as directed
  val people = Set("Alice", "Bob", "Charlie", "Derek", "Edith", "Fred")

  val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60
  )

  val favoriteColors =
    Map("Bob" -> "green", "Derek" -> "magenta", "Fred" -> "yellow")

  val favoriteLolcats = Map(
    "Alice" -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith" -> "Cloud Cat"
  )
  // END code copied from exercise description as directed

  // Write a method favoriteColor that accepts a person’s name as a parameter
  // and returns their favorite colour or defaults to be 'beige'
  def favoriteColor(name: String): String =
    favoriteColors.getOrElse(name, "beige")

  // Write a method printColors that prints everyone’s favorite color
  def printColors(): Unit = favoriteColors.values.foreach(println)

  // Write a method lookup that accepts a name and one of the maps and returns the relevant value from the map.
  def lookup[T](m: Map[String, T], name: String): T = m(name)

  val oldestPerson = ages.maxBy(_._2)._1
}
