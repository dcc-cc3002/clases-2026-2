package clase04

trait Duck {
  def m1(): Unit
  def m2(): Unit
}

trait Witch extends Duck { // Witch es un Duck: Witch <: Duck
  def m1(): Unit
  def m2(): Unit
}

class PatoLucas extends Witch {
  def m1(): Unit = {}
  def m2(): Unit = {}
}

object Main {
  def foo(d: Duck) = { d.m1() }
  val w: Witch = new PatoLucas()
  foo(w)
}
