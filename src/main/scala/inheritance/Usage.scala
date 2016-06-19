package inheritance

import JsonWritableImplicits._

case class Person(name: String, age: Int)

object Usage {

  val person = Person("paul", 30)

  def personWritable(p: Person): JsonWritable = {
    Map[String,JsonWritable](
      "name" -> p.name,
      "age" -> p.age
    )
  }

}