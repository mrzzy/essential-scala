/*
 * essential-scala
 * exercise 7.9 JSON Serialisation test
 */

package chapter7

import org.scalatest.flatspec.AnyFlatSpec
import JSONSerialization._
import java.util.Date
import java.time.Instant

class JSONSerializationTest extends AnyFlatSpec {
  behavior of "JSONSerialization"

  val createdAt = Date.from(Instant.EPOCH)
  val anonymous = Anonymous("42", createdAt)
  val user = User("21", "user@example.com", createdAt)

  "JSUtil.toJson" should "write Anonymous to as a JsValue" in {
    val createdAt = Date.from(Instant.EPOCH)
    val anonymousJs = JsUtil.toJson(anonymous)
    assert(
      anonymousJs == JsObject(
        Map("id" -> JsString("42"), "createdAt" -> JsString(createdAt.toString))
      )
    )
  }

  "JSUtil.toJson" should "write User to as a JsValue" in {
    val createdAt = Date.from(Instant.EPOCH)
    val userJs = JsUtil.toJson(user)
    assert(
      userJs == JsObject(
        Map(
          "id" -> JsString("21"),
          "email" -> JsString("user@example.com"),
          "createdAt" -> JsString(createdAt.toString)
        )
      )
    )
  }

  "JSUtil.toJson" should "write Visitor to as a JsValue" in {
    val anonymousJs = JsUtil.toJson(anonymous)
    val userJs = JsUtil.toJson(user)

    val visitors: Seq[Visitor] = Seq(anonymous, user)

    assert(
      JsUtil.toJson(visitors(0)) == anonymousJs
        &&
        JsUtil.toJson(visitors(1)) == userJs
    )
  }

  "Visitor.toJson" should "convert any Visitor to JSON string" in {
    val vistor: Visitor = user
    assert(
      anonymous.toJson == """{"id":"42","createdAt":"Thu Jan 01 07:30:00 SGT 1970"}"""
    )
    assert(
      vistor.toJson ==
        """{"id":"21","email":"user@example.com","createdAt":"Thu Jan 01 07:30:00 SGT 1970"}"""
    )
  }
}
