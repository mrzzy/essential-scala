/*
 * essential-scala
 * exercise 3.1.6.5 Counting Faster
 */

package chapter3;

class FasterCounter(val count: Int) {
  def inc(by: Int = 1) = new FasterCounter(count + by)
  def dec(by: Int = 1) = new FasterCounter(count - by)
  // method overrides to allow us to call .inc/.dec without ()
  def inc: FasterCounter = inc()
  def dec: FasterCounter = dec()
}
