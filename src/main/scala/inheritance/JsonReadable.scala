package inheritance

import json._

trait JsonReadable {
  def getValue(name: String): Option[JsonReadable]
  def getString(): Option[String]
  def getInt(): Option[Int]
  def getDouble(): Option[Double]
}

case class JsonReadableString(value: String) extends JsonReadable {
  def getValue(name: String) = None
  def getString() = Some(value)
  def getInt() = None
  def getDouble() = None
}

case class JsonReadableNumber(value: Double) extends JsonReadable {
  def getValue(name: String) = None
  def getString() = None
  def getInt() = Some(value.toInt)
  def getDouble() = Some(value)
}

case class JsonReadableObject(obj: Map[String,JsonReadable]) extends JsonReadable {
  def getValue(name: String) = obj.get(name)
  def getString() = None
  def getInt() = None
  def getDouble() = None
}

object JsonToReadable {
  def read(js: JsValue): JsonReadable = {
    js match {
      case JsString(value) => JsonReadableString(value)
      case JsNumber(value) => JsonReadableNumber(value)
      case JsObject(value) => JsonReadableObject(value.mapValues(read))
    }
  }
}
