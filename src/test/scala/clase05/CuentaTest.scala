package clase05

class CuentaTest extends munit.FunSuite {
  /* creamos nuestro fixture */
  var ca: Option[CuentaAhorro] = None
  var cc: Option[CuentaCorriente] = None

  override def beforeEach(context: BeforeEach): Unit =
    ca = Some(new CuentaAhorro("Lopez", 1_000_000))
    cc = Some(new CuentaCorriente("Manuela", 1_000_000, 1_000_000))

  test("cuenta de ahorro: giro simple") {
    ca.map { ca =>
      assert(ca.girar(500_000))
      assertEquals(ca.getSaldo, 500_000)
    }
  }
  test("cuenta de ahorro: girar mas de lo debido deberia fallar") {
    ca.map { ca =>
      ca.girar(500_000)
      assert(!ca.girar(1_000_000))
      assertEquals(ca.getSaldo, 500_000)
    }
  }

  test("cuenta de corriente: giro simple") {
    cc.map { cc =>
      assert(cc.girar(500_000))
      assertEquals(cc.getSaldo, 500_000)
    }
  }
  test(
    "cuenta de corriente: girar mas de lo debido deberia funcionar si no supera la linea de credito"
  ) {
    cc.map { cc =>
      cc.girar(500_000)
      assert(cc.girar(1_000_000))
      assertEquals(cc.getSaldo, -500_000)
      assert(!cc.girar(1_000_000))
      assertEquals(cc.getSaldo, -500_000)
    }
  }

  test("cuenta de ahorro: depositar") {
    ca.map { ca =>
      ca.depositar(500_000)
      assertEquals(ca.getSaldo, 1_500_000)
    }
  }

  test("cuenta corriente: depositar") {
    cc.map { cc =>
      cc.depositar(500_000)
      assertEquals(cc.getSaldo, 1_500_000)
    }
  }
  

}
