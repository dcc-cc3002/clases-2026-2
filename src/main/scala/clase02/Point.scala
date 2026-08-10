package clase02
trait Movable {
  def moveBy(deltaX: Int, deltaY: Int): Unit
}

class Point(var x: Int, var y: Int) extends Movable {
  def moveBy(deltaX: Int, deltaY: Int): Unit =
    x += deltaX
    y += deltaY
  override def toString(): String = {
    s"Punto($x, $y)"
  }
}

class Rectangle(val origin: Point, val height: Int, val width: Int)
    extends Movable {
  def moveBy(deltaX: Int, deltaY: Int): Unit = {
    // delegar!!
    origin.moveBy(deltaX, deltaY)
  }

  def area(): Int = height * width

  override def toString() = {
    s"Rectangle($origin, $height, $width)"
  }
}

@main def main(): Unit = {
  val p = new Point(10, 20)
  println(p)
  p.moveBy(5, 7)
  p.moveBy(19, 2)
  println(p)

  val r = new Rectangle(p, 100, 200)
  println(r)
  r.moveBy(10, 10)
  println(s"despues de mover queda asi: $r")

  def moveALot(x: Movable) = {
    x.moveBy(10000, 10000)
  }

  moveALot(p)
  moveALot(r)
  println(r)
  println(r.area())
}
