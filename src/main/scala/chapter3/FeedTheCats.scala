/*
 * essential-scala
 * exercise 3.5.3.1 Feed the Cats
 */

package chapter3

object ChipShop {
  def willServe(cat: CaseCat): Boolean = cat match {
    case CaseCat(_, _, "Chips") => true
    case default                => false
  }
}
