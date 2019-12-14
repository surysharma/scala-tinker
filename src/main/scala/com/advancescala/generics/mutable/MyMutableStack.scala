package com.advancescala.generics.mutable

import scala.collection.mutable.ArrayBuffer

object MyMutableStack extends App {

  /*
  A simple mutable Stack of type String.
   */
  trait MyStack {
    def push(element: String)
    def pop: Option[String]
    def peek
    def toArray: Array[String]
  }
  case class Node(element: String, var previousNode: Node = null)
  class MyMutableStack extends MyStack {

    var top: Node = null

    override def push(element: String): Unit = {

      if (top == null) {
        top = Node(element, null)
      }
      else{
        val currentNode = Node(element, top)
        top = currentNode
      }
      println(s"$element pushed in stack...")
    }

    override def pop: Option[String] = {
      if (top == null)
        None
      else {
        val topElement = top.element
        println(s"${top.element} popped from stack...")
        top = top.previousNode
        Some(topElement)
      }

    }

    override def peek: Unit = top.element

    override def toArray: Array[String] = {
      var currentNode = top
      val arryBuffer = new ArrayBuffer[String]()
      while (currentNode != null) {
        arryBuffer += currentNode.element
        currentNode = currentNode.previousNode
      }
      arryBuffer.toArray
    }
  }

  val stack = new MyMutableStack
  push("a")
  push("b")
  push("c")
  push("d")

  print

  pop
  pop
  pop
  pop

  print

  def push(element: String) = {
    stack.push(element)
  }

  def pop = stack.pop

  def print = {
    println("\nxxxxxxxx Stack xxxxxxxxxx")
    stack.toArray.foreach(println)
    println("xxxxxxxxxxxxxxxxxxxxxxxxx\n")
  }
}
