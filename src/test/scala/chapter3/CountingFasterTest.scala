/*
 * essential-scala
 * exercise 3.1.6.5 Counting Faster
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class FasterCounterTest extends AnyFlatSpec {
  behavior of "FasterCounter"

  it should "increment and decrement correctly" in {
    assert(new FasterCounter(10).inc.dec(6).inc(6).inc.count == 12)
  }
}
