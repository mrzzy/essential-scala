/*
 * essential-scala
 * exercises:
 * - 6.5.1.1 Adding Things
 * - 6.5.1.2 Adding All of the Things
 * - 6.6.2.1 Adding All the Things ++
 */

package chapter6

import scala.util.Try

object AddingThings {
  def addOptions(left: Option[Int], right: Option[Int]): Option[Int] = for (
    l <- left; r <- right
  ) yield l + r

  def addOptions(
      left: Option[Int],
      mid: Option[Int],
      right: Option[Int]
  ): Option[Int] = for (l <- left; r <- right; m <- mid) yield l + m + r

  def addTrys(
      left: Try[Int],
      mid: Try[Int],
      right: Try[Int]
  ): Try[Int] = for (l <- left; r <- right; m <- mid) yield l + m + r

  def addSeqs(
      left: Seq[Int],
      mid: Seq[Int],
      right: Seq[Int]
  ): Seq[Int] = for (l <- left; r <- right; m <- mid) yield l + m + r

  def addOptionsMap(
      left: Option[Int],
      mid: Option[Int],
      right: Option[Int]
  ): Option[Int] = left.flatMap { l =>
    mid.flatMap { m => right.map { r => l + m + r } }
  }
}
