/*
 * essential-scala
 * exercises tests:
 * - 7.3.4.1 Equality
 * - 7.4.4.1 Equality Again
 * - 7.6.3 Easy Equality
 */

package chapter7

import org.scalatest.flatspec.AnyFlatSpec
import Equality._

class EqualityTest extends AnyFlatSpec {
  behavior of "Equality"

  "Eq" should "use the implicit Equal[Person] implementation in scope" in {
    {
      // should use EmailPersonEqual implicitly
      import PersonEqualityByEmail._
      assert(
        Eq(
          Person("steven", "steven@example.com"),
          Person("steve", "steven@example.com")
        )
      )
    }

    {
      // should use NamePersonEqual implicitly
      import PersonEqualityByName._
      assert(
        Eq(
          Person("steve", "steve@example.com"),
          Person("steve", "steven@example.com")
        )
      )
    }
  }

  "Equal companion object" should "implicitly bring Equal[Person] implementation in scope" in {
    import PersonEqualityByEmail._
    assert(
      Equal[Person].equal(
        Person("steven", "steven@example.com"),
        Person("steve", "steven@example.com")
      )
    )
  }

  "===" should "implicitly use Equal[Person] implementation in scope and compare strings" in {
    import StringCaseInsentiveEquality._
    import StringImplicits._

    assert("ABCd" === "abcd")
  }
}
