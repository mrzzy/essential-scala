/*
 * essential-scala
 * exercise 6.10.2 Probabilities
 */

package chapter6

final case class Distribution[E](eventProbs: List[(E, Double)]) {
  // BEGIN code copied from exercise description
  def normalize: Distribution[E] = {
    val totalWeight = (eventProbs map { case (a, p) => p }).sum
    Distribution(eventProbs map { case (a, p) => a -> (p / totalWeight) })
  }

  def compact: Distribution[E] = {
    val distinct = (eventProbs map { case (a, p) => a }).distinct
    def prob(a: E): Double =
      (eventProbs filter { case (x, p) => x == a } map { case (a, p) => p }).sum

    Distribution(distinct map { a => a -> prob(a) })
  }
  // END code copied from exercise description

  def map[B](f: ((E, Double)) => B): Distribution[B] = {
    Distribution(eventProbs.map { case (event, prob) =>
      f((event, prob)) -> prob
    })
  }

  def flatMap[B](f: ((E, Double)) => Distribution[B]): Distribution[B] = {
    eventProbs.map(f).fold(Distribution[B]()) {
      case (dist1, dist2) => {
        Distribution(dist1.eventProbs ::: dist2.eventProbs).compact.normalize
      }
    }
  }
}

object Distribution {
  def apply[E](eventProbs: List[(E, Double)] = List()): Distribution[E] =
    new Distribution[E](eventProbs)

  def uniform[E](events: Seq[E]): Distribution[E] = Distribution(
    events.map { e => (e, 1.0 / events.length) }.toList
  )
}
