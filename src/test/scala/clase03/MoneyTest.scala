package clase03

import munit.FunSuite

class MoneyTest extends FunSuite {
  var _12clp: Money = null
  var _14clp: Money = null

  override def beforeEach(context: BeforeEach): Unit =
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")

  test("Igualdad de dos objetos Money con mismo monto y divisa") {
    assertEquals(_12clp, _12clp)
    assertEquals(_12clp, new Money(12, "CLP"))
    assertNotEquals(_12clp, _14clp)
  }
  test("Money puede sumarse con otro objeto de la misma divisa") {
    assertEquals(_12clp.add(_14clp), new Money(26, "CLP"))
  }
}
