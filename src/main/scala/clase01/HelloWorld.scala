package clase01

object HelloWorld {

  def hailstones(n: Int, acc: List[Int] = List()): List[Int] = {
    if (n == 1) {
      println("calculamos hailstone! y el resultado es " + (1 :: acc))
      1 :: acc
    } else {
      val nacc = n :: acc
      if (n % 2 == 0) hailstones(n / 2, nacc)
      else hailstones(3 * n + 1, nacc)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Hello World")
    val x = hailstones(3)
    println("haciendo otras cositas...")

    println("Ingrese su nombre:")
    val name = scala.io.StdIn.readLine()
    println("Ingrese su edad:")
    val age = scala.io.StdIn.readLine()

    println(s"Hola ${age}, tu edad es ${name}")
  }
}
