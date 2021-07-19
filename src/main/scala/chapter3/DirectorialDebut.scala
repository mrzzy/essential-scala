/*
 * essential-scala
 * exercise 3.1.6.3 Directorial Debut
 */

package chapter3

// use case class here to get automatic equals method
case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = s"${firstName} ${lastName}"
}

case class Film(
    name: String,
    yearOfRelease: Int,
    imdbRating: Double,
    director: Director
) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director): Boolean = d == director

  def copy(
      name: String = name,
      yearOfRelease: Int = yearOfRelease,
      imdbRating: Double = imdbRating,
      director: Director = director
  ) = {
    Film(name, yearOfRelease, imdbRating, director)
  }
}
