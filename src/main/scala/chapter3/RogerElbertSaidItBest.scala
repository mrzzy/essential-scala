/*
 * essential-scala
 * exercise 3.4.5.2 Roger Ebert Said it Best…
 */

package chapter3;

case class CaseDirector(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = s"${firstName} ${lastName}"
}

// companion object for CaseDirector
object CaseDirector {
  def older(
      first: CaseDirector,
      second: CaseDirector
  ): CaseDirector = {
    if (first.yearOfBirth < second.yearOfBirth) first else second
  }
}

case class CaseFilm(
    name: String,
    yearOfRelease: Int,
    imdbRating: Double,
    director: CaseDirector
) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: CaseDirector): Boolean = d == director
}

// companion object for CaseFilm
case object CaseFilm {
  def apply(
      name: String,
      yearOfRelease: Int,
      imdbRating: Double,
      director: CaseDirector
  ): CaseFilm = new CaseFilm(name, yearOfRelease, imdbRating, director)

  def highestRating(first: CaseFilm, second: CaseFilm): CaseFilm = {
    if (first.imdbRating > second.imdbRating) first else second
  }

  def oldestDirectorAtTheTime(
      first: CaseFilm,
      second: CaseFilm
  ): CaseDirector = {
    if (first.directorsAge > second.directorsAge) first.director
    else second.director
  }
}
