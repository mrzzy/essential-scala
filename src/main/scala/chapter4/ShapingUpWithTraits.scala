/*
 * essential-scala
 * exercises:
 * - 4.1.4.2 Shaping Up With Traits
 * - 4.1.4.3 Shaping Up 2 (Da Streets)
 * - 4.2.2.1 Printing Shapes
 * - 4.2.2.2 The Color and the Shape
 */

package chapter4

sealed trait Shape {
  def sides: Int // no. of sides
  def perimeter: Double // total length of all sides
  def area: Double
  def color: Color
}

case class Circle(radius: Int, color: Color = Red(), sides: Int = 0)
    extends Shape {
  def perimeter: Double = 2 * Math.PI * radius
  def area: Double = Math.pow(Math.PI * radius, 2)
}

// common trait for all rectangular shapes
sealed trait Rectangular extends Shape {
  def length: Int
  def width: Int

  // concrete attributes of rectangular shaps
  def sides: Int = 4
  def perimeter: Double = 2 * length + 2 * width
  def area: Double = length * width
}

case class Rectangle(length: Int, width: Int, color: Color = Red())
    extends Rectangular

case class Square(length: Int, color: Color = Red()) extends Rectangular {
  def width: Int = length
}
