println("***************Strategy pattern implementation  ***********")


/*
Requirment 1:
This need to be implemented by Mallard Duck, RedheadDuck and
in future potentially RubberDuck and WooodenDuck
 */

/************ API code starts ****************/
trait Duck {
  val name: String
   def swim(): Unit = println(name + ": swimming....")
   def display(): Unit = println(name + ":look at me...")
}
  //def quack() //this can change from client to client
  //def fly() //this can change from client to client


trait Quackable extends Duck{
  def quack() = {
    println("Default Quackable")
  }
}
trait Flyable extends Duck{
  def fly() ={
    println("Default flyable")
  }
}

/**
  * The issue here is that we are exposing a client an api which is not working like
  * woodenClient.quack(), woodenClient.fly()
  * The way to solve this issue is to first find
  * which of these Duck behaviours have the possibility of change.
  * We see that all ducks have the behaviour of swim() and display(),
  * so they remain constant.
  */

class CommonDuck(val name: String) extends Duck

/************ API code ends ****************/


//On the client side we are injecting the differnt behaviours as per the client's need
val droneDuck = new CommonDuck("DroneDuck") with Flyable {
  override def fly(): Unit = println("Drone flying duck")
}

val smartDroneDuck =new CommonDuck("SmartDroneDuck") with Quackable with Flyable {
  override def quack(): Unit = println("Smart Quacking drone duck")
  override def fly(): Unit = println("Smart Flying drone duck")
}

val squeakingDuck = new CommonDuck("SqeakDuck") with Quackable {
  override def quack(): Unit = println("Squeak squeak")
}

val mallardDuck = new CommonDuck("MallardDuck") with Quackable with Flyable {
  override def quack(): Unit = {
    println("Malladu qucking says: ")
    super.quack()
  }
}

mallardDuck.display()
mallardDuck.swim()
mallardDuck.fly()
mallardDuck.quack()
println("********* Squeacking duck start ******* ")
squeakingDuck.swim()
squeakingDuck.display()
squeakingDuck.quack()
println("********* Squeacking duck end ******* ")




println("Mallard Calling client")
//For Mallard duck the client can use any api
val mallardClient = new CommonDuck("MallardDuck") with Quackable with Flyable
mallardClient.quack()
mallardClient.fly()
mallardClient.swim()

println("Wooden Calling client")
val woodenClient = new CommonDuck("WoodenDuck")
woodenClient.swim()
woodenClient.display()












