/*
 * essential-scala
 * exercises tests:
 * - 7.1.6.1 More Orderings
 * - 7.1.6.2 Rational Orderings
 */

package chapter7

import org.scalatest.flatspec.AnyFlatSpec
import MoreOrderings._

class MoreOrderingsTest extends AnyFlatSpec {
  behavior of "MoreOrderings"

  "absOrdering" should "Order ints from lowest to highest by absolute value" in {
    // test case derived from exercise description
    assert(List(-4, -1, 0, 2, 3).sorted(absOrdering) == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted(absOrdering) == List(-1, -2, -3, -4))
  }

  "absOrdering" should "Order ints from lowest to highest by absolute value implicitly" in {
    // test case derived from exercise description
    implicit val ordering = absOrdering
    assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))
  }

  "rationalOrdering" should "Order rational no.s from lowest to highest by absolute value" in {
    // test case derived from exercise description
    implicit val ordering = rationalOrdering
    assert(
      List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(1, 3), Rational(1, 2), Rational(3, 4))
    )
  }
}
