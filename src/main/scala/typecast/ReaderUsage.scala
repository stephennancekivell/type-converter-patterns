package typecast

import json._

object ReaderUsage {

	case class Person(name: String, age: Int)

	val json = JsObject(
		Map(
			"name" -> JsString("Bill"),
			"age" -> JsNumber(25))
		)

	def read(js: JsValue): Person = {
    val parsed = JsonReader.read(json).asInstanceOf[Map[String,Any]]

    Person(
      name = parsed.get("name").asInstanceOf[String],
      age = parsed.get("age").asInstanceOf[Double].toInt
    )
	}
}

