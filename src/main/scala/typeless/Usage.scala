package typeless

object Usage {

	def formatForSolr(x: Any): String = {
		x match {
			case i: Int => i.toString
			case str: String => str
			case SeqOfString(xs) => xs.mkString(",")
			case _ => throw new RuntimeException("surprise!")
		}
	}

}

case class SeqOfString(xs: Seq[String])
