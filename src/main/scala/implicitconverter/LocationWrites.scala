package implicitconverter

import json.JsObject
import StandardWrites._

case class Location(latitude: Double, longitude: Double)

class LocationWrites extends Writes[Location] {
  def write(a: Location) = JsObject(
    Map(
    "lat" -> a.latitude,
    "lng" -> a.longitude
    )
  )
}
