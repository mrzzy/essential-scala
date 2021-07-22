/*
 * essential-scala
 * exercise 6.8.3.1 Favorites test
 */

package chapter6

import org.scalatest.flatspec.AnyFlatSpec
import test.TestUtil.runCaptureOut
import Favorites._

class FavoritesTest extends AnyFlatSpec {
  behavior of "Favorites"

  "favoriteColor" should "return the person given by name's favorite color or default to beige" in {
    assert(favoriteColor("Fred") == "yellow")
    assert(favoriteColor("does not exist") == "beige")
  }

  "printColors" should "print everyone’s favorite color" in {
    assert(
      runCaptureOut(() => printColors()) == favoriteColors.values.mkString(
        "\n"
        // println prints a newline for each element
        // using mkString, we will be missing one newline, hence manually added here.
      ) + "\n"
    )
  }

  "lookup" should "get value for name for any given map" in {
    for {
      m <- Seq(favoriteColors, favoriteLolcats, ages)
      (name, expectedValue) <- m
    } assert(lookup(m, name) == expectedValue)
  }

  "oldestPerson" should "contain the name of the oldest person by age" in {
    assert(oldestPerson == "Fred")
  }
}
