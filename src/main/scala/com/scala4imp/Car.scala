package com.scala4imp

class Car(year: Int, miles: Int){
  Car.increment

  private var state = 0
  def this(year: Int) = this(year, 0)

  def citiesTravelled(cities: List[Int]) = {
    var count = 0
    for (city <- cities){
      count += city
    }
    state = count
  }

  def getCitiesTravelled = state

  def isVowel(ch: Char) = {
    "aeiou".contains(ch)
  }
//"timbukto"
  def recurVowels(str: String): String = {
    if (str.length == 0) {
      ""
    }
    else {
      val head = str.head
      val tail = recurVowels(str.tail)
      if (isVowel(head)){
        head + tail
      } else {
        tail
      }
    }
  }


}

object Car {

  def apply(year: Int, miles: Int): Car = new Car(year, miles)
  def apply(year: Int): Car = this(year, 0)

  var count = 0
  def countInstances() = {
    count
  }

  def increment() = {
    count += 1
  }

}



object Driver extends App {
  val c1 = Car(2010, 50000)

  val c2 = Car(2011, 50000)
  val c3 = Car(2012, 50000)
  val c4 = Car(2018)

  println("Total cars is " + Car.countInstances)

  c1.citiesTravelled(List(1,2,3))
  println("Car travelled in following cities = " + c1.getCitiesTravelled)

  println("Car travelled in following cities = " + c1.getCitiesTravelled)

  val vowels = c1.recurVowels("timbukto")

  println(vowels)
}