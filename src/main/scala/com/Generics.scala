package com


object GenericDrier extends App {

  abstract class MyList[+T] {
    def head: T
    def tail: MyList[T]
    def isEmpty: Boolean
    def add[S >: T](item: S): MyList[S]
  }


  object Empty extends MyList[Nothing] {

    override def head: Nothing = throw new NoSuchElementException

    override def tail: MyList[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def add[S](item: S): MyList[S] = new Element(item, Empty)

     override def toString: String = "Empty"

  }

  class Element[+T](h: T, t: MyList[T]) extends MyList[T] {

    override def head: T = h

    override def tail:  MyList[T] = t

    override def isEmpty: Boolean = false

    override def add[S >: T](item: S):  MyList[S] = new Element(item, this)

  }

  class Vehicle
  class Car extends Vehicle
  class Bike extends Vehicle

  val coVariList: MyList[Car] = Empty.add(new Car)
  coVariList.add(new Bike)



  private val carInList: MyList[Car] = Empty.add(new Car)
  private val vehicleInList:MyList[Vehicle] = carInList.add(new Vehicle)
  val vehicleList: MyList[Vehicle] = vehicleInList.add(new Bike)

  println(vehicleList)




}
