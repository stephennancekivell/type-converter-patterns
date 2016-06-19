package inheritance

case class Person(name: String, age: Int)

object Usage {

  val person = Person("paul", 30)

  def personWritable(p: Person): JsonWritable = {
    JsonWritableObject(
      Map(
        "name" -> JsonWritableString(p.name),
        "age" -> JsonWritableInt(p.age)
      )
    )
  }

  val json = personWritable(person).toJson()

}