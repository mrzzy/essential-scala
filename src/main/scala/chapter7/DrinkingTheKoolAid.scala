/*
 * essential-scala
 * exercise:
 * - 7.6.2.1 Drinking the Kool Aid
 * - 7.6.2.2 Times
 * - 7.8.3.1 Implicit Class Conversion
 */

package chapter7

object DrinkingTheKoolAid {
  object IntImplicits {
    // syntaxtical sugar: for the class definition  + implicit conversion
    // implicit class IntOpts(int: Int){

    // class definition: defines extra methods for the Int type
    class IntOpts(val int: Int) {
      // prints 'yeah' int times
      def yeah(): Unit = int.times(_ => println("yeah"))

      // performs the given function f int times
      def times(f: Int => Unit): Unit = {
        for (_ <- 0 until int) {
          f(int)
        }
      }
    }

    // implicit conversion from Int to IntOpts
    implicit def toIntOpts(int: Int): IntOpts = new IntOpts(int)
  }
}
