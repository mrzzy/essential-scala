/*
 * essential-scala
 * exercise 3.3.2.2 Extended Body of Work
 */

package chapter3;

// copied from DirectorialDebug.scala with 'Extended' name prefix
class ExtendedDirector(
    val firstName: String,
    val lastName: String,
    val yearOfBirth: Int
) {
  def name = s"${firstName} ${lastName}"
}

// companion object for ExtendedDirector
object ExtendedDirector {
  def apply(
      firstName: String,
      lastName: String,
      yearOfBirth: Int
  ): ExtendedDirector = {
    new ExtendedDirector(firstName, lastName, yearOfBirth)
  }

  def older(
      first: ExtendedDirector,
      second: ExtendedDirector
  ): ExtendedDirector = {
    if (first.yearOfBirth < second.yearOfBirth) first else second
  }
}

// copied from DirectorialDebug.scala with 'Extended' name prefix
class ExtendedFilm(
    val name: String,
    val yearOfRelease: Int,
    val imdbRating: Double,
    val director: ExtendedDirector
) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: ExtendedDirector): Boolean = d == director

  def copy(
      name: String = name,
      yearOfRelease: Int = yearOfRelease,
      imdbRating: Double = imdbRating,
      director: ExtendedDirector = director
  ) = {
    new ExtendedFilm(name, yearOfRelease, imdbRating, director)
  }
}

// companion object for ExtendedFilm
object ExtendedFilm {
  def apply(
      name: String,
      yearOfRelease: Int,
      imdbRating: Double,
      director: ExtendedDirector
  ): ExtendedFilm = new ExtendedFilm(name, yearOfRelease, imdbRating, director)

  def highestRating(first: ExtendedFilm, second: ExtendedFilm): ExtendedFilm = {
    if (first.imdbRating > second.imdbRating) first else second
  }

  def oldestDirectorAtTheTime(
      first: ExtendedFilm,
      second: ExtendedFilm
  ): ExtendedDirector = {
    if (first.directorsAge > second.directorsAge) first.director
    else second.director
  }
}
