/*
 * essential-scala
 * exercise 3.1.6.4 A Simple Counter
 */

package chapter3

class Counter(val count: Int) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
}
