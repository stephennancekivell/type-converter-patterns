package implicitconverter

import json._

import StandardReads._

trait Reads[A] {
  def read(v: JsValue): Either[String,A]
}

object StandardReads {
  implicit val stringReads = new Reads[String] {
    def read(v: JsValue) = v match {
      case JsString(str) => Right(str)
      case other => Left("couldnt find string in "+other)
    }
  }

  implicit val intReads = new Reads[Int] {
    def read(v: JsValue) = v match {
      case JsNumber(d) => Right(d.toInt)
      case other => Left("couldnt find int in "+other)
    }
  }

  implicit val intDouble = new Reads[Double] {
    def read(v: JsValue) = v match {
      case JsNumber(d) => Right(d)
      case other => Left("couldnt find double in "+other)
    }
  }

  implicit val mapReader = new Reads[Map[String,JsValue]] {
    def read(v: JsValue) = v match {
      case JsObject(value) => Right(value)
      case other => Left("couldnt parse map in "+other)
    }
  }

  implicit def toJsValueOpts(js: JsValue): JsValueOpts = new JsValueOpts(js)
}

class JsValueOpts(js: JsValue) {
  def as[T](implicit reads: Reads[T]): Either[String, T] = reads.read(js)

  def getAs[T](key: String)(implicit reads: Reads[T]) = {
    for {
      obj <- as[Map[String,JsValue]].right
      key <- obj.get(key).toRight("couldnt find key "+key).right
      v <- reads.read(key).right
    } yield v
  }
}