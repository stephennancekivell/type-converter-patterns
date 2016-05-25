package inheritance

case class Person(name: String, age: Int)

case class MyString(value: String) extends JsonWritable {
  def toJson(): JsValue = JsString(value)
}

case class MyInt(value: Int) extends JsonWritable {
  def toJson(): JsValue = JsNumber(value.toDouble)
}

object Usage {

  val person = Person("paul", 30)


  def toJsonyTypes(p: Person) = {
    Map(
      "name" -> MyString(p.name),
      "age" -> MyInt(p.age)
    )
  }

  def write(x: Map[String, JsonWritable]): Map[String, JsValue] = {
    x.mapValues(_.toJson)
  }

  trait Color extends JsonWritable {
    def toJson(): JsValue
  }


}