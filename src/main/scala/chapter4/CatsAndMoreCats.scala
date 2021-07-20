/*
 * essential-scala
 * exercise 4.1.4.1 Cats, and More Cats
 */

package chapter4

trait Feline {
  def color: String
  def sound: String
}

case class Cat(color: String, food: String, sound: String = "meow")
    extends Feline
case class Tiger(color: String, sound: String = "roar") extends Feline
case class Panther(color: String, sound: String = "roar") extends Feline
case class Lion(color: String, maneSize: Int, sound: String = "roar")
    extends Feline
