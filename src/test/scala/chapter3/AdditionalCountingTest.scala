/*
 * essential-scala
 * exercise 3.1.6.6 Additional Counting
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class AddtionalCountingTest extends AnyFlatSpec {
  behavior of "AddCounter"

  it should "adjust with given adder" in {
    val add6 = new Adder(6)
    assert(new AddCounter(2).adjust(add6).inc.count == 9)
  }
}

