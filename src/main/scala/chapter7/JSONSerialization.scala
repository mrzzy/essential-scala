/*
 * essential-scala
 * exercise 7.9 JSON Serialisation
 * subexercises:
 * - 7.9.1 Convert X to JSON
 */

package chapter7

import java.util.Date
import chapter7.JSONSerialization.Anonymous
import chapter7.JSONSerialization.User

object JSONSerialization {
  // BEGIN code copied from exercise description
  // demo data ADTs copied from exercise description to demo Json serialisation
  sealed trait Visitor {
    def id: String
    def createdAt: Date
    def age: Long = new Date().getTime() - createdAt.getTime()
  }

  final case class Anonymous(
      id: String,
      createdAt: Date = new Date()
  ) extends Visitor

  final case class User(
      id: String,
      email: String,
      createdAt: Date = new Date()
  ) extends Visitor

  // JSON ADTs copied from exercise description
  sealed trait JsValue {
    def stringify: String
  }

  final case class JsObject(values: Map[String, JsValue]) extends JsValue {
    def stringify = values
      .map { case (name, value) => "\"" + name + "\":" + value.stringify }
      .mkString("{", ",", "}")
  }

  final case class JsString(value: String) extends JsValue {
    def stringify = "\"" + value.replaceAll("\\|\"", "\\\\$1") + "\""
  }

  // END code copied from exercisef description
  object JsUtil {
    // converts given value to JSOn, using the given implicit writer
    def toJson[A](value: A)(implicit writer: JsWriter[A]) =
      writer.toJsValue(value)
  }

  // JsWriter trait converts a Scala value to a JsValue
  sealed trait JsWriter[A] {
    def toJsValue(value: A): JsValue
  }

  // JsWriter type class instances for converting Visitor ADTs to JsValues
  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    def toJsValue(value: Anonymous): JsValue = {
      JsObject(
        Map(
          "id" -> JsString(value.id),
          "createdAt" -> JsString(value.createdAt.toString)
        )
      )
    }
  }

  implicit object UserJsWriter extends JsWriter[User] {
    def toJsValue(value: User): JsValue = {
      JsObject(
        Map(
          "id" -> JsString(value.id),
          "email" -> JsString(value.email.toString),
          "createdAt" -> JsString(value.createdAt.toString)
        )
      )
    }
  }

  implicit object VisitorWriter extends JsWriter[Visitor] {
    def toJsValue(value: Visitor): JsValue = value match {
      case anon: Anonymous => JsUtil.toJson(anon)
      case user: User      => JsUtil.toJson(user)
    }
  }

  // implicit class to add toJson convience method to Visitor ADTs
  implicit class VisitorJsonOps(vistor: Visitor) {
    def toJson(): String = JsUtil.toJson(vistor).stringify
  }
}
