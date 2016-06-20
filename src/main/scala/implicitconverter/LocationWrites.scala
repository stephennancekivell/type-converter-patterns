package implicitconverter

import json._
import StandardWrites._
import StandardReads._

case class Location(latitude: Double, longitude: Double)

object LocationFormat extends Writes[Location] with Reads[Location]{

  def write(a: Location) = JsObject(
    Map(
    "lat" -> a.latitude,
    "lng" -> a.longitude
    )
  )

  def read(js: JsValue): Either[String, Location] = for {
    lat <- js.getAs[Double]("lat").right
    lng <- js.getAs[Double]("lng").right
  } yield Location(lat,lng)
}