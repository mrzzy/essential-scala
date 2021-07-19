/*
 * essential-scala
 * exercise 3.3.2.2 Extended Body of Work
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class ExtendedBodyOfWorkTest extends AnyFlatSpec {
  behavior of "ExtendedBodyOfWork"

  "ExtendedDirector" should "create ExtendedDirector instance with apply()" in {
    val nolan = ExtendedDirector("Christopher", "Nolan", 1970)
    assert(
      nolan.firstName == "Christopher" && nolan.lastName == "Nolan" &&
      nolan.yearOfBirth == 1970
    )
  }

  "ExtendedDirector" should "return the older of two directors" in {
    val nolan    = ExtendedDirector("Christopher", "Nolan", 1970)
    val eastwood = ExtendedDirector("Clint", "Eastwood", 1930)
    assert(ExtendedDirector.older(nolan, eastwood).name == "Clint Eastwood")
  }

  "ExtendedFilm" should "create ExtendedFilm instance with apply()" in {
    val nolan   = ExtendedDirector("Christopher", "Nolan", 1970)
    val memento = ExtendedFilm("Memento", 2000, 8.5, nolan)
    assert(
      memento.name == "Memento" && memento.yearOfRelease == 2000 && 
      memento.imdbRating == 8.5 && memento.director == nolan
    )
  }

  "ExtendedFilm" should "return the highest rated of two film" in {
    val nolan      = ExtendedDirector("Christopher", "Nolan", 1970)
    val memento    = ExtendedFilm("Memento", 2000, 8.5, nolan)
    val darkKnight = ExtendedFilm("Dark Knight", 2008, 9.0, nolan)

    assert(ExtendedFilm.highestRating(memento, darkKnight) === darkKnight)
  }

  "ExtendedFilm" should "return the director who was oldest at the time of filming" in {
    val mcTiernan = ExtendedDirector("John", "McTiernan", 1951)
    val nolan     = ExtendedDirector("Christopher", "Nolan", 1970)

    val inception = ExtendedFilm("Inception", 2010, 8.8, nolan)
    val predator  = ExtendedFilm("Predator", 1987, 7.9, mcTiernan)

    assert(ExtendedFilm.oldestDirectorAtTheTime(inception, predator) == nolan)
  }
}
