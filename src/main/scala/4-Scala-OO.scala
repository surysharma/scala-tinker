import java.time.LocalDateTime

case class CashFlow(amount: Double, currency: String, due: LocalDateTime) {
  def this(amount: Double, currency: String) = this(amount, currency, LocalDateTime.now())

}

case class Account(val balance: Double, val currency: String) {


  def deposit(amount: Double) = {
    new Account(this.balance + amount, this.currency)
  }

  def withdraw(amount: Double) = {
    new Account(this.balance - amount, this.currency)
  }

  def trackBalance(): Double = this.balance
}


//Companion object CashFlow is a singleton corresponding to the original class cashFlow
object CashFlow {

  def main(array: Array[String]) = {

    val account = new Account(24, "GBP")
    println(s"Initial balance ${account.trackBalance()}")

    deposit(10)
    withdrawl(15)


    def deposit(amount: Double) = println(s"Amount deposited ${amount}, Available balance : ${account.deposit(amount).trackBalance()}")

    def withdrawl(amount: Double) = println(s"Amount withdrawl ${amount}, Available balance : ${account.withdraw(amount).trackBalance()}")

  }
}