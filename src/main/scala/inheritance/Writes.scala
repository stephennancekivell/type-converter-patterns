package inheritance

import json._

trait JsonWritable {
  def toJson(): JsValue
}

case class JsonWritableString(value: String) extends JsonWritable {
  def toJson(): JsValue =
    JsString(value)
}

case class JsonWritableInt(value: Int) extends JsonWritable {
  def toJson(): JsValue =
    JsNumber(value.toDouble)
}

case class JsonWritableObject(obj: Map[String,JsonWritable]) extends JsonWritable {
  def toJson(): JsValue =
    JsObject(
      obj.mapValues(_.toJson())
    )
}

object JsonWritableImplicits {
  implicit def toJson(a: String): JsonWritable =
    JsonWritableString(a)

  implicit def toJson(a: Int): JsonWritable =
    JsonWritableInt(a)

  implicit def toJson(a: Map[String, JsonWritable]): JsonWritable =
    JsonWritableObject(a)
}