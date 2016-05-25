package implicitconverter

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



  implicit def toJsValueOpts(js: JsValue): JsValueOpts = new JsValueOpts(js)
}

class JsValueOpts(js: JsValue) {
  def as[T](implicit reads: Reads[T]): Either[String, T] = reads.read(js)
}