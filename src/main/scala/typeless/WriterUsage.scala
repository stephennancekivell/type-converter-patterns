package typeless

import json._

object WriterUsage {

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