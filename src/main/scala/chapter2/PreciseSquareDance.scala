/*
 * essential-scala
 * exercise 2.4.5.3: Precise Square Dance!
 */

package chapter2

object PreciseSquareDance {
  object calc {
    // use method overloading to provide implementations for both Double & Int
    def square(x: Double) = x * x
    def square(x: Int) = x * x
  }
}
