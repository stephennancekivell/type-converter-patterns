package inheritance

import json._

object ReadsUsage {

  case class Person(name: String, age: Int)

  val json = JsObject(
    Map(
      "name" -> JsString("Bill"),
      "age" -> JsNumber(25))
  )

  val parsed = JsonToReadable.read(json)

  def read(js: JsValue): Person = {
    Person(
      name = parsed.getValue("name").get.getString().get,
      age = parsed.getValue("age").get.getDouble().get.toInt
    )
  }
}
