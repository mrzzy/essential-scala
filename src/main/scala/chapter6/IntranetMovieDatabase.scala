/*
 * essential-scala
 * exercise 6.1.9.3 Intranet Movie Database
 */

package chapter6

object IntranetMovieDatabase {
  // BEGIN code pasted from exercise description
  case class Film(name: String, yearOfRelease: Int, imdbRating: Double)

  case class Director(
      firstName: String,
      lastName: String,
      yearOfBirth: Int,
      films: Seq[Film]
  )

  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)

  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)

  val eastwood = new Director(
    "Clint",
    "Eastwood",
    1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus)
  )

  val mcTiernan = new Director(
    "John",
    "McTiernan",
    1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair)
  )

  val nolan = new Director(
    "Christopher",
    "Nolan",
    1970,
    Seq(memento, darkKnight, inception)
  )

  val someGuy = new Director("Just", "Some Guy", 1990, Seq())

  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)
  // END code pasted from exercise description

  // find all directors who have directed more than numberOfFilms:
  // Accept a parameter numberOfFilms of type Int
  def filterDirector(noOfFilms: Int): Seq[Director] =
    directors.filter(_.films.length > noOfFilms)

  // find a director who was born before that year:
  // Accept a parameter year of type In
  def findDirectorYOBBefore(year: Int): Option[Director] =
    directors.find(_.yearOfBirth < year)

  // return a list of directors who were born before year who have also directed more than than numberOfFilms.
  // Accept two parameters, year and numberOfFilms.
  def filterDirector(year: Int, numberOfFilms: Int): List[Director] =
    (findDirectorYOBBefore(year).toSet intersect filterDirector(
      numberOfFilms
    ).toSet).toList

  // Sort the directors by age in the specified order:
  // Accept a parameter ascending of type Boolean that defaults to true.
  def sortDirector(ascending: Boolean = true): Seq[Director] =
    directors.sortWith { (d1, d2) =>
      {
        // yearOfBirth is inversely correlated with age
        if (ascending) d1.yearOfBirth >= d2.yearOfBirth
        else d1.yearOfBirth < d2.yearOfBirth
      }
    }
}
