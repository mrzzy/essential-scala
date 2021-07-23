/*
 * essential-scala
 * exercise 7.2.5.1 Ordering Orders
 */

package chapter7

object OrderingOrders {
  // represents an order of a spec item in a shop
  final case class Order(units: Int, unitPrice: Double) {
    val totalPrice: Double = units * unitPrice
  }

  object Order {
    // ordering by total price is a reasonable default ordering,
    // hence we place it in the compainion object so that its the default order used to order orders
    implicit val ordering =
      Ordering.fromLessThan[Order](_.totalPrice < _.totalPrice)
  }

  object OrderUnitsOrdering {
    // ordering by no. of units
    implicit val ordering = Ordering.fromLessThan[Order](_.units < _.units)
  }

  object OrderUnitPriceOrdering {
    // ordering by no. of unitPrice
    implicit val ordering =
      Ordering.fromLessThan[Order](_.unitPrice < _.unitPrice)
  }
}
