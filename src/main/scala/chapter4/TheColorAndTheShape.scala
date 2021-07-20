/*
 * essential-scala
 * exercise 4.2.2.2 The Color and the Shape
 */

package chapter4

sealed trait Color {
  // color represented in RGB color space
  def red: Int
  def green: Int
  def blue: Int

  // whether a color is considered 'light' or 'dark'
  def brightness: String = {
    val averageValue = (red + green + blue) / 3.0
    if ((averageValue / 255.0) >= 0.5) "light" else "dark"
  }
}

// predefineed colors
final case class Red(red: Int = 255, green: Int = 0, blue: Int = 0)
    extends Color {
  override def toString: String = "red"
}

final case class Yellow(red: Int = 255, green: Int = 255, blue: Int = 0)
    extends Color {
  override def toString: String = "yellow"
}

final case class Pink(red: Int = 255, green: Int = 192, blue: Int = 203)
    extends Color {
  override def toString: String = "pink"
}

// custom color
case class CustomColor(red: Int, green: Int, blue: Int) extends Color {
  override def toString: String = brightness
}
