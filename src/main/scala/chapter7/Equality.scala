/*
 * essential-scala
 * exercises:
 * - 7.3.4.1 Equality
 * - 7.4.4.1 Equality Again
 * - 7.6.3 Easy Equality
 */

package chapter7

object Equality {
  // represents a person
  // derived from the exercise description
  case class Person(name: String, email: String)

  trait Equal[A] {
    // compares whether left and right are equal
    def equal(left: A, right: A): Boolean
  }

  // no-argument apply method pattern used to be automatically implicitly obtain Equal[A]
  object Equal {
    def apply[A](implicit equality: Equal[A]): Equal[A] = equality
  }

  object PersonEqualityByEmail {
    implicit object EmailPersonEqual extends Equal[Person] {
      def equal(left: Person, right: Person): Boolean =
        left.email == right.email
    }
  }

  object PersonEqualityByName {
    implicit object NamePersonEqual extends Equal[Person] {
      def equal(left: Person, right: Person): Boolean = left.name == right.name
    }
  }

  object StringCaseInsentiveEquality {
    implicit object StringCaseInsensitive extends Equal[String] {
      def equal(left: String, right: String): Boolean =
        left.toLowerCase == right.toLowerCase
    }
  }

  object Eq {
    def apply[A](left: A, right: A)(implicit equality: Equal[A]): Boolean =
      equality.equal(left, right)
  }

  object StringImplicits {
    // adds a custom equality operator '===' that uses an implicit Equal[String] to compare strings
    implicit class CustomEqualityOperator(string: String) {
      def ===(other: String)(implicit equality: Equal[String]): Boolean =
        equality.equal(string, other)
    }
  }
}
