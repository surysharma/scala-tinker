package com.funcProgInScala.chap1

object Coffee_exp1Driver extends App {


  class CreditCard{
    def charge(amount: BigDecimal) = {}
  }
  class Coffee {
   def price = BigDecimal(2)
  }

  //Cafe - with Side effects
  class CafeWithSideEffects {

    def buyCoffee(cc: CreditCard): Coffee = {
      val coffee = new Coffee
      cc.charge(coffee.price)  // Method causing side-effects
      coffee
    }
  }

  case class Charge(cc: CreditCard, coffeePrice: BigDecimal) {
    def merge(anotherCharge: Charge): Charge = {
      if (anotherCharge.cc == cc) Charge(cc, anotherCharge.coffeePrice + coffeePrice)
      else throw new RuntimeException("Card mismatch error!")
    }
  }

  //Cafe - without any Side effects
  class Cafe {

    //Single function without any side-effects and a predictable output.
    def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
      val coffee = new Coffee
      (coffee, Charge(cc, coffee.price)) //No- side effects here!
    }

    //How about a someone who buys multiple coffees from the cafe?
    //Single function returning all Coffees and the total cost
    def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
      val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
      val (coffees, charges): (List[Coffee], List[Charge]) = purchases.unzip
      val result: (List[Coffee], Charge) = (coffees, charges.reduce((charge1, charge2) => charge1.merge(charge2)))
      result
    }
  }
}
