/*
 * essential-scala
 * exercise 3.1.6.3 Directorial Debut test
*/

package chapter3

import org.scalatest.flatspec.AnyFlatSpec

class DirectorialDebutTest extends AnyFlatSpec {
  // demo directors given by exercise description
  val eastwood          = Director("Clint", "Eastwood", 1930)
  val mcTiernan         = Director("John", "McTiernan", 1951)
  val nolan             = Director("Christopher", "Nolan", 1970)
  val someBody          = Director("Just", "Some Body", 1990)

  // demo films given by exercise description
  val memento           = Film("Memento", 2000, 8.5, nolan)
  val darkKnight        = Film("Dark Knight", 2008, 9.0, nolan)
  val inception         = Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales  = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven        = Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino        = Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus          = Film("Invictus", 2009, 7.4, eastwood)

  val predator          = Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard           = Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  behavior of "DirectorialDebut"
  
  "Director.yearOfBirth" should "return director's year of birth" in {
    assert(eastwood.yearOfBirth  == 1930)
  }
  
  "Film.director.name" should "return film's director's name" in {
    assert(dieHard.director.name == "John McTiernan")
  }

  "Film.isDirectedBy" should "determine whether film is director by a director" in {
    assert(invictus.isDirectedBy(nolan) == false)
  }
  
  "Film.copy" should "copy film with field overrides" in {
    assert(highPlainsDrifter.copy(name = "L'homme des hautes plaines")
      == Film("L'homme des hautes plaines", 1973, 7.7, eastwood))
 
    val jewison = Director("Norman", "Jewison", 1926)
    assert(thomasCrownAffair.copy(yearOfRelease = 1968, director=jewison)
      == Film("The Thomas Crown Affair" ,1968,6.8, jewison))
    
    assert(inception.copy().copy().copy() == inception)
  }
}

