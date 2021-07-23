/*
 * essential-scala
 * exercise 7.6.2.1 Drinking the Kool Aid test
 */

package chapter7

import org.scalatest.flatspec.AnyFlatSpec
import DrinkingTheKoolAid.IntImplicits._
import test.TestUtil.runCaptureOut

class DrinkingTheKoolAidTest extends AnyFlatSpec {
  behavior of "DrinkingTheKoolAid"

  "int" should "use IntExtras implicit and provide .yeah method & print 'yeah' for positive Ints" in {
    assert(runCaptureOut(() => 3.yeah) == "yeah\nyeah\nyeah\n")
    assert(runCaptureOut(() => -1.yeah) == "")
  }

  "times" should "perform the given function int times" in {
    assert(
      runCaptureOut(() =>
        3.times(i => println(s"yo ${i}"))
      ) == "yo 3\nyo 3\nyo 3\n"
    )
  }
}
