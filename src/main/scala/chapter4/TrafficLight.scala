/*
 * essential-scala
 * exercises:
 * - 4.4.4.1 Stop on a Dime
 * - 4.5.6.1 Traffic Lights
 */

package chapter4

// sum-type: is-a, and relationship
sealed trait TrafficLight {
  def next: TrafficLight = {
    this match {
      case RedLight    => GreenLight
      case GreenLight  => YellowLight
      case YellowLight => GreenLight
    }
  }
}
final case object RedLight extends TrafficLight
final case object YellowLight extends TrafficLight
final case object GreenLight extends TrafficLight
