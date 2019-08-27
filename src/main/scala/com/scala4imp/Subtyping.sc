abstract class Food

class Chicken extends Food {
  override def toString: String = "Delicious Chicken"
}

class Grass extends Food {
  override def toString: String = "Crunchy  Grass"
}

abstract class Animal {
  type FoodType <: Food
  def eat(food: FoodType)
}

class Cow extends Animal {
  type FoodType = Grass
  override def eat(grass: Grass): Unit = println(s"Cow eating $grass")
}

class Cat extends Animal {
  override type FoodType = Chicken

  override def eat(food: Chicken): Unit = println(s"Dog eating $food")
}

object SubtypingDriver extends App{
  val grass = new Grass

  val cow = new Cow


  println(cow eat grass)

}