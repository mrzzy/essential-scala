/*
 * essential-scala
 * exercise 3.5.3.2 Get Off My Lawn!
 */

package chapter3;

object Dad {
  def rate(film: CaseFilm) = film.director match {
    case CaseDirector("Clint", "Eastwood", _) => 10.0
    case CaseDirector("John", "McTiernan", _) => 7.0
    case default                              => 3.0
  }
}
