package clase03

object Playground {
  def main(args: Array[String]): Unit = {
    val x: Option[String] = Some("hola")
    val y: Option[Int] = Some(1)
    val m = if (y.isDefined) {
      y.get + 1
    }
    val z: Option[Int] = None
    z.get // error
    val n = y.getOrElse(0)
  }
}
