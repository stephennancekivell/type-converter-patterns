package typecast

import json._

object JsonReader {

  def read(js: JsValue): Any = {
    js match {
      case JsString(value) => value
      case JsNumber(value) => value
      case JsObject(value) => value.mapValues(read)
    }
  }
}
