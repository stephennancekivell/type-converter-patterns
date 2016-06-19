package json

sealed trait JsValue
case class JsString(value: String) extends JsValue
case class JsNumber(value: Double) extends JsValue
case class JsObject(value: Map[String, JsValue]) extends JsValue