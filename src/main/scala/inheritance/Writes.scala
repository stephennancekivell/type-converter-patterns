package inheritance

trait JsonWritable {
  def toJson(): JsValue
}