package implicitconverter

import StandardWrites._
import json._

object WritesUsage {

  case class Person(name: String, age: Int)

  val personWrites = new Writes[Person] {
    def write(a: Person): JsValue = {
      Map[String,JsValue](
        "name" -> a.name,
        "age" -> a.age
      )
    }
  }

  val json = personWrites.write(Person("Bill", 25))

}
