/*
 * essential-scala
 * exercise 7.2.5.1 Ordering Orders test
 */

package chapter7

import org.scalatest.flatspec.AnyFlatSpec
import OrderingOrders._

class OrderingOrdersTest extends AnyFlatSpec {
  behavior of "OrderingOrders"

  "Order" should "order by total price by default" in {
    assert(
      List(Order(3, 0.5), Order(1, 2.0), Order(2, 0.6)).sorted ==
        List(Order(2, 0.6), Order(3, 0.5), Order(1, 2.0))
    )
  }
}
