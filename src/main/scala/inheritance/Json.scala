package inheritance

sealed trait JsValue
case class JsString(value: String) extends JsValue
case class JsNumber(value: Double) extends JsValue