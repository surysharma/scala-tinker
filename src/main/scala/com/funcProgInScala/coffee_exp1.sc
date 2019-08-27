class CreditCard

class Coffee{
  val price: Double = 2.40
}

case class Charge(cc: CreditCard, price: Double) {
  def combine(other: Charge) = {
    Charge(cc, this.price + other.price)
  }
}

def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
  val coffee = new Coffee
  (coffee, Charge(cc, coffee.price))
}

def totalCoffeeCost(cc: CreditCard, noOfCoffees: Int) = {

  val coffeesList: List[(Coffee, Charge)] = List.fill(noOfCoffees)(buyCoffee(cc))

  val (coffees, charges):(List[Coffee], List[Charge]) = coffeesList.unzip

  (coffees, charges.reduce(_ combine _))
}


def curriedSum(x: Int)(y: Int) = x + y

val s1 = curriedSum(3)(_)

s1(8)