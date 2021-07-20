/*
 * essential-scala
 * exercises:
 * - 4.4.4.1 Stop on a Dime
 * - 4.5.6.1 Traffic Lights
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class TrafficLightTest extends AnyFlatSpec {
  behavior of "TrafficLight"

  it should "change to next TrafficLight in order" in {
    assert(RedLight.next == GreenLight)
    assert(GreenLight.next == YellowLight)
    assert(YellowLight.next == GreenLight)
  }
}
