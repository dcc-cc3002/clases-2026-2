package clase05

trait Tree {
  def sum: Int
  def min: Int
  def max: Int
}

class Node(value: Int, left: Tree, right: Tree) extends Tree {
  def sum: Int = value + left.sum + right.sum
  def min: Int = Math.min(value, Math.min(left.min, right.min))
  def max: Int = Math.max(value, Math.max(left.max, right.max))
}
class Leaf(value: Int) extends Tree {
  def sum: Int = value
  def min: Int = value
  def max: Int = value
}
class Empty extends Tree{
  def sum: Int = 0
  def min: Int = Integer.MAX_VALUE
  def max: Int = Integer.MIN_VALUE
}

