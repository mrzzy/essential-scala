/*
 * essential-scala
 * exercise 4.4.4.3 Water, Water, Everywhere
 */

// sum-type: is-a, or relationship
sealed trait Source
final case class Well() extends Source
final case class Spring() extends Source
final case class Tap() extends Source

// product-type: has-a, and relationship
trait BottledWater {
  def source: Source
  def carbonated: Boolean
}
