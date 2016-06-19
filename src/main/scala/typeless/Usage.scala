package typeless

import json._

object JsonWriter {

	def toJson(value: Any): JsValue = value match {
		case v: String => JsString(v)
		case v: Int => JsNumber(v.toDouble)
		case v: Map[String,Any] =>
			JsObject(
				v.mapValues(toJson))
	}
}

object Usage {

  case class Person(name: String, age: Int)

  def write(p: Person): JsValue = {
    JsonWriter.toJson(
      Map(
        "name" -> p.name,
        "age" -> p.age
      )
    )
  }

  val json = write(Person("Bill", 25))
}