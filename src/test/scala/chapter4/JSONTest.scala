/*
 * essential-scala
 * exercise 4.7.0.2 JSON test
 */

package chapter4

import org.scalatest.flatspec.AnyFlatSpec

class JSONTest extends AnyFlatSpec {
  behavior of "JSON"

  it should """represent ["a string", 1.0, true]""" in {
    JSONElement(
      JSONString("a String"),
      JSONElement(JSONNumber(1.0), JSONElement(JSONBool(true), JSONArrayEnd))
    )
  }

  it should """represent
{
  "a": [1,2,3],
  "b": ["a","b","c"]
  "c": { "doh":true, "ray":false, "me":1 }
}
  """ in {
    // "a": [1,2,3],
    JSONAttribute(
      key = JSONString("a"),
      value = JSONElement(
        JSONNumber(1),
        JSONElement(JSONNumber(2), JSONElement(JSONNumber(3), JSONArrayEnd))
      ),
      // "b": ["a","b","c"]
      tail = JSONAttribute(
        key = JSONString("b"),
        value = JSONElement(
          JSONString("a"),
          JSONElement(
            JSONString("b"),
            JSONElement(JSONString("c"), JSONArrayEnd)
          )
        ),
        // "c": { "doh":true, "ray":false, "me":1 }
        tail = JSONAttribute(
          key = JSONString("c"),
          value = JSONAttribute(
            key = JSONString("doh"),
            value = JSONBool(true),
            tail = JSONAttribute(
              key = JSONString("ray"),
              value = JSONBool(false),
              tail = JSONAttribute(
                key = JSONString("me"),
                value = JSONNumber(1),
                tail = JSONObjectEnd
              )
            )
          ),
          tail = JSONObjectEnd
        )
      )
    )
  }

}
