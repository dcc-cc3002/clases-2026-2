package clase05

class TreeTest extends munit.FunSuite {
  val tree =
    new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))

  test("suma de un arbol") {
    assertEquals(tree.sum, 121)
  }
  test("min de un arbol") {
    assertEquals(tree.min, 4)
  }
  test("max de un arbol") {
    assertEquals(tree.max, 45)
  }
}
