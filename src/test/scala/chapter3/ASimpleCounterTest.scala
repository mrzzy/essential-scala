/*
 * essential-scala
 * exercise 3.1.6.4 A Simple Counter
 */

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class ASimpleCounterTest extends AnyFlatSpec {
  behavior of "Counter"

  it should "increment and decrement correctly" in {
    assert(new Counter(10).inc.dec.inc.inc.count == 12)
  }
}
