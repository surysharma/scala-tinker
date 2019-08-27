trait Car{
  def assemble(description: String) = println("Car :"+ description)
}

trait SportsCar extends Car {
  override def assemble(description: String): Unit = {
    println("SportsCar :"+ description)
    super.assemble(description)
  }
}

trait LuxuryCar extends Car {
  override def assemble(description: String): Unit = {
    println("LuxuryCar :"+ description)
    super.assemble(description)
  }
}

trait ElectricCar extends Car {
  val capacityInMiles = 300

  override def assemble(description: String): Unit = {
    println(f"ElectricCar ${capacityInMiles} Miles Range: ${description} :")
    super.assemble(description)
  }
}

//Concrete implementation of Car
class BasicCar extends Car {
  override def assemble(description: String): Unit = {
    println("BasicCar :"+ description)
    super.assemble(description)
  }
}

//Mixin the other traits to BasicCar Object
val car = new BasicCar with ElectricCar with SportsCar with LuxuryCar {
 override val capacityInMiles = 200
}
car.assemble("Honda Civic ")