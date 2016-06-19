package implicitconverter

import StandardReads._
import json._

object ReadsUsage {

  val data: Map[String, JsValue] = Map()

  def get[T](name: String)(implicit reads: Reads[T]): Either[String, T] = {
    data.get(name).map(_.as[T])
      .getOrElse(Left(s"no field $name"))
  }

  val name = get[String]("name")
  val age = get[Int]("age")

  val parsed: Either[String, (String, Int)] = for {
    name <- get[String]("name").right
    age <- get[Int]("age").right
  } yield name -> age


  // easy to extend.

  trait Color
  case object Red extends Color

  implicit val colorReads = new Reads[Color]{
    def read(a: JsValue) =
      a.as[String].right.flatMap {
        case "red" => Right(Red)
        case other => Left(s"dont know color $other")
      }
  }

  val color = get[Color]("the color")
}