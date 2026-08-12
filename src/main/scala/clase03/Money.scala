package clase03

class Money(val value: Int, val currency: String) {
  def add(other: Money): Money = {
    // asumimos que tenemos la misma divisa
    new Money(value + other.value, currency)
  }
  def +(other: Money): Money = add(other)
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val otherMoney: Money = other.asInstanceOf[Money] // Cast
      value == otherMoney.value && currency == otherMoney.currency
    } else false
  }
  override def toString(): String = {
    s"Money($value,$currency)"
  }
}
