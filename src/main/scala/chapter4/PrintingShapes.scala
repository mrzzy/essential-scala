/*
 * essential-scala
 * exercise:
 * - 4.2.2.1 Printing Shapes
 * - 4.2.2.2 The Color and the Shape
 */

package chapter4

object Draw {
  def apply(shape: Shape) = shape match {
    case Circle(radius, color, _) => f"A $color circle of radius $radius%.1fcm"
    case Rectangle(length, width, color) =>
      f"A $color rectangle of width $width%.1fcm and length $length%.1fcm"
    case Square(length, color) => f"A $color square of length $length%.1fcm"
  }
}
