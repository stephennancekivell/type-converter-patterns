package implicitconverter

import StandardWrites._
import json._

object WritesUsage {

  implicit val locationWrites = new Writes[Location] {
    def write(a: Location) = JsObject(
      Map(
        "lat" -> a.latitude,
        "lng" -> a.longitude
      )
    )
  }

  case class Person(name: String, age: Int, location: Location)

  val personWrites = new Writes[Person] {
    def write(a: Person) = JsObject(
      Map(
        "name" -> a.name,
        "age" -> a.age,
        "location" -> a.location
      )
    )
  }


  case class Location(latitude: Double, longitude: Double)
}
