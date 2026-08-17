package clase03

import munit.FunSuite

class MoneyTest extends FunSuite {
  var _12clp: Money = null
  var _14clp: Money = null
  var _7usd: Money = null
  var mb1: MoneyBag = null

  override def beforeEach(context: BeforeEach): Unit =
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")
    _7usd = new Money(7, "USD")
    mb1 = new MoneyBag()
    mb1.add(_12clp)
    mb1.add(_14clp)
    mb1.add(_7usd)

  test("Igualdad de dos objetos Money con mismo monto y divisa") {
    assertEquals(_12clp, _12clp)
    assertEquals(_12clp, new Money(12, "CLP"))
    assertNotEquals(_12clp, _14clp)
  }
  test("Money puede sumarse con otro objeto de la misma divisa") {
    assertEquals(_12clp.add(_14clp), new Money(26, "CLP"))
  }
  test("igualdad de un moneybag") {
    assertEquals(mb1, mb1)
    val mb2 = new MoneyBag(List(_12clp, _14clp, _7usd))
    assertEquals(mb1, mb2)
  }
  test("A un moneybag se le deberia poder agregar monedas") {

    assertEquals(mb1.size, 2)
    assertEquals(mb1.get("CLP"), Some(_12clp.add(_14clp)))
    assertEquals(mb1.get("USD"), Some(_7usd))
  }

  test(
    "Money sumado a otro Money de distinta divisa deberia retornar una bolsa de monedas"
  ) {
    _12clp.add(_14clp) // deberia devolver un Money
    _12clp.add(_7usd) // deberia devolver un MoneyBag
  }
}
