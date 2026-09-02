package clase07

object SobreCarga {
  class A {
    def foo(): Unit =
      this.bar(new C)
      println("A.foo")
    def bar(a: A): Unit = println("A.bar")
  }
  class B extends A {
    def bar(a: B): Unit = println("B.bar")
  }
  class C extends B {
    override def foo(): Unit =
      super.foo()
      println("C.foo")
    def bar(a: C): Unit = println("C.bar")
  }
  def main(args: Array[String]): Unit = {
    val c = new C()
    c.foo()
  }
  trait Weapon
  class Sword extends Weapon
  
  class Staff extends Weapon
  
  class Dagger extends Weapon
  
  def foo(x: Weapon
         ): Unit = {}
}
