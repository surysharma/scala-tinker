/**

   Exercise 4-Scala & OO

	• Create a copy the Cashflow class into you projecr
	• Use a basic form (amount, currency & date)

	Write an Account class that will:
	• Track the balance(& in which currency)
	• Have deposit & withdrawl() methods

	Add an overload of deposit() that accepts a Cashflow
	• Check that the Cashflow is of the correct currency
	• What should the return type of deposit() bel?
	• Should withdraw() have the same return type as deposit()?

	Create a subclass of Account - a DepositAccount that
	• Cannot be overdrawn
	• What happens if a too-big withderal is attempted?

	Add a new subclass of Account - EurodollarAccount
	• Has two balances - one in EUR (Euros) and one in USD
	• How shall we model this?
	• Write additional deposit and withdrawal methods as needed
	• What happens to the simple forms of deposit() etc?

  */
package j4sd.exercies

import java.time.LocalDate

case class CashFlow(amount: Double, currency: String, valueDate: LocalDate)

case class Balance(amount: Double, currency: String)


class Account(val accountNo: String, val balance: Double, val currency: String) {

  def checkBalance() = Balance(balance, currency)

  def deposit(amount: Double) = Balance(amount + balance, currency)

  def deposit(cashFlow: CashFlow): Option[Balance] = {
    cashFlow.currency match {
      case this.currency => Some(Balance(cashFlow.amount + this.balance, this.currency))
      case _ => None
    }
  }

  def withdraw(amount: Double):Balance = {
    Balance(balance - amount, currency)
  }
}

class DepositAccount(accountNo: String, balance: Double, currency: String) extends Account(accountNo,balance, currency){

  override def withdraw(amount: Double): Option[Balance] =  {
    amount match {
      case amount if (amount > balance) => Some(Balance(balance - amount, currency))
      case _ => None
    }
  }
}


/*

class EuroDollarAccount(accountNo: String, balance: Balance) extends Account(accountNo, balance.amount, balance.currency){
  override def deposit(amount: Double): Balance = {
    case
    super.deposit(amount)
  }
}

 */



