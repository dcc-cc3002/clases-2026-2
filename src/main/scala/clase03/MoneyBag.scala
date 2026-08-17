package clase03
import scala.collection.mutable.Map
type Currency = String
class MoneyBag() {
  val moneys: Map[Currency, Money] = Map()

  def this(l: List[Money]) = {
    this()
    // l.foreach(m => add(m))
    for (m <- l) {
      add(m)
    }
  }

  def add(m: Money): Unit = {
    // buscamos si tenemos una moneda con esa divisa
    if (moneys.isDefinedAt(m.currency)) {
      // si la tenemos,
      // (1) la obtenemos
      val actual: Option[Money] =
        moneys.get(m.currency) // String => Option[Money]
      // (2) la sumamos a la nueva, y
      val nueva = m.add(actual.get)
      // (3) actualizamos nuestro monedero
      moneys += (m.currency -> nueva)
    } else {
      // Y si no la tenemos, la agregamos a nuestro monedero.
      moneys += (m.currency -> m)
    }

    /*moneys += (m.currency -> moneys
      .get(m.currency)
      .map(actual => m.add(actual))
      .getOrElse(m))*/

  }

  def size: Int = moneys.size

  def get(x: Currency): Option[Money] = moneys.get(x)

  override def equals(obj: Any): Boolean = {
    obj match {
      case mb: MoneyBag => mb.moneys == moneys
      case _            => false
    }
  }
}
