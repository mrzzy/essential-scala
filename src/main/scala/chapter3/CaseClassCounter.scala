/*
 * essential-scala
 * exercise 3.4.5.3 Case Class Counter
 */

package chapter3;

case class CaseCounter(count: Int = 0) {
  def inc(by: Int = 1): CaseCounter = copy(count = count + by)
  def dec(by: Int = 1): CaseCounter = copy(count = count - by)
  // method overrides to allow us to call .inc/.dec without ()
  def inc: CaseCounter = inc()
  def dec: CaseCounter = dec()
}
