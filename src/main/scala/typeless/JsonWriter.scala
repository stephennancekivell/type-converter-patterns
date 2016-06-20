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
