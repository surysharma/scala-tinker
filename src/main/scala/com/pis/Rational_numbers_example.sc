class RationalNumber(val numerator: Int, val denominator: Int) {

  require(denominator != 0)//Precondition checked here

  def this(numerator: Int) = {
    this(numerator, 1)
  }

  def +(other: RationalNumber): RationalNumber = {
    val numerator1 = (denominator * other.numerator)
    val commonDenominator = (denominator * other.denominator)

    val numerator2 = (other.denominator * numerator)

    new RationalNumber(numerator1 + numerator2, commonDenominator)
  }

  def *(other: RationalNumber) = {
    new RationalNumber(numerator * other.numerator, denominator * other.denominator)
  }

  override def toString(): String = {
    s"${numerator}/${denominator}"
  }
}

val r1 = new RationalNumber(1,2)
val r2 = new RationalNumber(2,3)

val r3 = new RationalNumber(3)

r1+r3

