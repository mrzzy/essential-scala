/*
 * essential-scala
 * exercise 6.10.1 Random Words
 */

package chapter6

object RandomWords {
  val subjects = List("Noel", "The cat", "The dog")
  val verbs = List("wrote", "chased", "slept on")
  val objects = List("the book", "the ball", "the bed")

  // Write a program to generate all possible sentences
  def getAll(
      subjects: List[String] = subjects,
      verbs: List[String] = verbs,
      objects: List[String] = objects
  ) = {
    for {
      s <- subjects
      v <- verbs
      o <- objects
    } yield s"$s $v $o"
  }

  // conditional model for generating sentences
  def getVerbs(subject: String) = subject match {
    case "Noel"    => Seq("wrote", "chased", "slept on")
    case "The cat" => Seq("meowed at", "chased", "slept on")
    case "The dog" => Seq("barked at", "chased", "slept on")
  }

  def getObject(verb: String) = verb match {
    case "wrote"     => Seq("the book", "the letter", "the code")
    case "chased"    => Seq("the ball", "the dog", "the cat")
    case "slept on"  => Seq("the bed", "the mat", "the train")
    case "meowed at" => Seq("Noel", "the door", "the food cupboard")
    case "barked at" => Seq("the postman", "the car", "the cat")
  }

  def getConditional(
      subjects: List[String] = subjects
  ) = {
    for {
      s <- subjects
      v <- getVerbs(s)
      o <- getObject(v)
    } yield s"$s $v $o"
  }
}
