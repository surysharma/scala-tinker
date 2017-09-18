import java.time.LocalDateTime

case class CashFlow(amount: Double, currency: String, due: LocalDateTime) {
  def this(amount: Double, currency: String) = this(amount, currency, LocalDateTime.now())

}

case class Account(val balance: Double, val currency: String) {


  def deposit(amount: Double) = {
    new Account(this.balance + amount, this.currency)
  }

  /*
  Overloaded deposit function with return type Any
   */
  def deposit(cashFlow: CashFlow): Any = {
    if (currency.equalsIgnoreCase(cashFlow.currency)) {
      new Account(this.balance + cashFlow.amount, currency)
    }  else {
      println(s"Sorry, invalid currency amount!")
    }
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

    def depositCashFlow(account: Any, cashFlow: CashFlow) = {
      if (account.isInstanceOf[Account]){
        val acct = account.asInstanceOf[Account]
        println(s"Amount deposited ${cashFlow.amount}, Available balance : ${acct.trackBalance()}")
      }
      else{
        println("CashFlow instance not applied...")
      }

    }


    println(s"Initial balance ${account.trackBalance()}")

    val updatedAcct1 = account.deposit(10)
    println(s"Amount deposited 10, Available balance : ${updatedAcct1.trackBalance()}")

    val updatedAcct2 = updatedAcct1.withdraw(15)
    println(s"Amount withdraw 15, Available balance : ${updatedAcct2.trackBalance()}")

    val updatedAcct3 = updatedAcct2.withdraw(5)
    println(s"Amount withdraw 5, Available balance : ${updatedAcct3.trackBalance()}")


    val cashFlow = new CashFlow(10, "GBP")
    val updatedAcct4 = updatedAcct3.deposit(cashFlow)
    depositCashFlow(updatedAcct4, cashFlow)

  }
}