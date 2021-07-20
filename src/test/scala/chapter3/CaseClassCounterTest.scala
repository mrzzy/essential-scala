/*
 * essential-scala
 * exercise 3.4.5.3 Case Class Counter
 */

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class CaseClassCounterTest extends AnyFlatSpec {
  behavior of "CaseCounter"

  it should "increment and decrement correctly" in {
    assert(CaseCounter(10).inc.dec(6).inc(6).inc.count == 12)
  }
}
