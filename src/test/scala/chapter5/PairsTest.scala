/*
 * essential-scala
 * exercise 5.4.1.1: Pairs test
 */

package chapter5

import org.scalatest.flatspec.AnyFlatSpec

class PairsTest extends AnyFlatSpec {
  behavior of "Pair"

  it should "Store both Int and String" in {
    val pair = Pair("hi", 2)
    assert(pair.one == "hi")
    assert(pair.two == 2)
  }
}
