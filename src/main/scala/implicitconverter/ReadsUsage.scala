package implicitconverter

import StandardReads._
import json._

object ReadsUsage {

  case class Person(name: String, age: Int)

  val obj = JsObject(
    Map(
      "name" -> JsString("Bill"),
      "age" -> JsNumber(25)
    )
  )

  for {
    name <- obj.getAs[String]("name").right
    age <- obj.getAs[Int]("age").right
  } yield Person(name, age)
}