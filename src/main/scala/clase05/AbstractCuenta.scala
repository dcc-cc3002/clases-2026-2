package clase05
import scala.collection.mutable.ListBuffer

/** Queremos modelar cuentas de ahorro y cuentas corrientes Ambas permiten girar
  * y depositar, tambien registrar los movientos que se hacen en la cuenta. La
  * diferencia entre ambas cuentas es que la cuenta de ahorro tiene una linea de
  * credito que permite girar mas de el saldo disponible.
  */

abstract class AbstractCuenta(val nombre: String, saldoInicial: Int) {
  private var saldo = saldoInicial
  def getSaldo: Int = saldo
  def setSaldo(newSaldo: Int) = saldo = newSaldo
  def depositar(monto: Int) = saldo += monto

  def girar(monto: Int): Boolean = {
    if (puedeGirar(monto)) {
      setSaldo(getSaldo - monto)
      true
    } else false
  }
  def puedeGirar(monto: Int): Boolean
}

class CuentaAhorro(nombre: String, saldoInicial: Int)
    extends AbstractCuenta(nombre, saldoInicial) {
  // private val movimientos: ListBuffer[String] = ListBuffer()
  def puedeGirar(monto: Int): Boolean = monto <= getSaldo
}

class CuentaCorriente(nombre: String, saldoInicial: Int, linea: Int)
    extends AbstractCuenta(nombre, saldoInicial) {

  def puedeGirar(monto: Int) = monto <= getSaldo + linea

}
