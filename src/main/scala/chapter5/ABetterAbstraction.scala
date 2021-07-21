/*
 * essential-scala
 * exercise 5.2.3.1 A Better Abstraction
 */

package chapter5

sealed trait IntList {
  // fold accumulates IntList using given function 'f'
  def fold[T](end: T, f: (Int, T) => T): T = {
    this match {
      case IntEnd => end
      case IntNode(head, tail) => {
        f(head, tail.fold(end, f))
      }
    }
  }

  def length: Int = fold(0, (_, tailLen: Int) => 1 + tailLen)

  def sum: Int = fold(0, (head, tailSum: Int) => head + tailSum)

  def product: Int = fold(1, (head, tailProd: Int) => head * tailProd)

  def double: IntList =
    fold(IntEnd, (head, tailDouble: IntList) => IntNode(head * 2, tailDouble))
}
case object IntEnd extends IntList
final case class IntNode(head: Int, tail: IntList) extends IntList
