/*
 * essential-scala
 * exercise 3.1.6.6 Additional Counting
 */

package chapter3

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class AddCounter(count: Int) extends Counter(count) {
  def adjust(adder: Adder): AddCounter = {
    new AddCounter(adder.add(count))
  }
}
