/*
 * essential-scala
 * exercise 4.7.0.2 JSON
 */

package chapter4

/* JSON syntax BNF form
 * <object> ::= "{"  "}" | "{"  <definitions>  "}"
 * <definitions> ::= <definition> | <definition> ","  <definitions>
 * <definition> ::=  <string>  :  <value>
 * <value> ::= <string> | <number> | <array> | <object>
 * <array> ::= "[" <valueSeq> "]"
 * <valueSeq>:= <value> | <value>, <valueSeq>
 */

sealed trait JSONObject extends JSONValue
final case object JSONObjectEnd extends JSONObject
final case class JSONAttribute(
    key: JSONString,
    value: JSONValue,
    tail: JSONObject
) extends JSONObject

sealed trait JSONArray extends JSONValue
final case object JSONArrayEnd extends JSONArray
final case class JSONElement(head: JSONValue, tail: JSONArray) extends JSONArray

sealed trait JSONValue
final case class JSONString(value: String) extends JSONValue
final case class JSONNumber(value: Double) extends JSONValue
final case class JSONBool(value: Boolean) extends JSONValue
