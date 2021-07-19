/*
 * essential-scala
 * exercise 3.4.5.2 Roger Ebert Said it Best... test
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class RogerEbertSaidItBestTest extends AnyFlatSpec {
  behavior of "RogerEbertSaidItBest"

  "CaseDirector" should "create CaseDirector instance with apply()" in {
    val nolan = CaseDirector("Christopher", "Nolan", 1970)
    assert(
      nolan.firstName == "Christopher" && nolan.lastName == "Nolan" &&
      nolan.yearOfBirth == 1970
    )
  }

  "CaseDirector" should "return the older of two directors" in {
    val nolan    = CaseDirector("Christopher", "Nolan", 1970)
    val eastwood = CaseDirector("Clint", "Eastwood", 1930)
    assert(CaseDirector.older(nolan, eastwood).name == "Clint Eastwood")
  }

  "CaseFilm" should "create CaseFilm instance with apply()" in {
    val nolan   = CaseDirector("Christopher", "Nolan", 1970)
    val memento = CaseFilm("Memento", 2000, 8.5, nolan)
    assert(
      memento.name == "Memento" && memento.yearOfRelease == 2000 && 
      memento.imdbRating == 8.5 && memento.director == nolan
    )
  }

  "CaseFilm" should "return the highest rated of two film" in {
    val nolan      = CaseDirector("Christopher", "Nolan", 1970)
    val memento    = CaseFilm("Memento", 2000, 8.5, nolan)
    val darkKnight = CaseFilm("Dark Knight", 2008, 9.0, nolan)

    assert(CaseFilm.highestRating(memento, darkKnight) === darkKnight)
  }

  "CaseFilm" should "return the director who was oldest at the time of filming" in {
    val mcTiernan = CaseDirector("John", "McTiernan", 1951)
    val nolan     = CaseDirector("Christopher", "Nolan", 1970)

    val inception = CaseFilm("Inception", 2010, 8.8, nolan)
    val predator  = CaseFilm("Predator", 1987, 7.9, mcTiernan)

    assert(CaseFilm.oldestDirectorAtTheTime(inception, predator) == nolan)
  }
}
