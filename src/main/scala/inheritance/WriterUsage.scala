package inheritance

import json._

object WriterUsage {

  case class Person(name: String, age: Int) extends JsonWritable {
    def toJson(): JsValue = {
      JsonWritableObject(
        Map(
          "name" -> JsonWritableString(name),
          "age" -> JsonWritableInt(age)
        )
      ).toJson()
    }
  }

  val person = Person("Bill", 25)

  val json = person.toJson()
}