/*
 * essential-scala
 * exercise 6.1.9.2 Animals
 */

package chapter6

object Animals {
  val animals = Seq("cat", "dog", "penguin")
  val moreAnimals = "mouse" +: animals :+ "tyrannosaurus"
  // scala infers that the common supertype between Int (2) and String is Any
  // hence the returned sequence 'notJustAnimals' is Seq[Any]
  val notJustAnimals = 2 +: moreAnimals
}
