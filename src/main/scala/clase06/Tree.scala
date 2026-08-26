package clase06

trait Tree extends Comparable[Tree] {
  def sum: Int
  def min: Int
  def max: Int
}

abstract class AbstractTree extends Tree {
  def compareTo(o: Tree): Int = {
    min.compareTo(o.min)
  }
  override def toString(): String = s"Tree(sum=$sum, min=$min, max=$max)"
}

class Node(value: Int, left: Tree, right: Tree) extends AbstractTree {
  def sum: Int = value + left.sum + right.sum
  def min: Int = Math.min(value, Math.min(left.min, right.min))
  def max: Int = Math.max(value, Math.max(left.max, right.max))
}
class Leaf(value: Int) extends AbstractTree {
  def sum: Int = value
  def min: Int = value
  def max: Int = value
}
class Empty extends AbstractTree {
  def sum: Int = 0
  def min: Int = Integer.MAX_VALUE
  def max: Int = Integer.MIN_VALUE
}

object Main {
  def main(args: Array[String]): Unit = {
    val t1 = new Node(43, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(6))
    val t2 = new Node(46, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))
    val t3 = new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(5))
    println(List(t1, t2, t3).sortBy(n => n.max))
  }

}
