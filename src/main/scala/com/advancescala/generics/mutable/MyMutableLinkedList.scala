package com.advancescala.generics.mutable

import scala.collection.mutable.ArrayBuffer

object MyMutableLinkedList extends App {

  /*
  A simple mutable linked list of type String.
   */
  trait MyLL {
    def append(String: String)
    def addAfter(index: Int, element: String)
    def getFirst: String
    def getLast: String
    def toArray: Array[String]
  }
  case class Node(element: String, var previousNode: Node = null)
  class MyLinkedList extends MyLL {

    private var head: Node = null
    private var tail: Node = null
    private var previousHead: Node = null

    override def append(element: String): Unit = {
      if (head == null) {
        head = Node(element)
        tail = head
      }else {
        previousHead = head
        head = Node(element, previousHead)
      }
    }

    override def addAfter(index: Int, element: String): Unit = {

      var currentNode = head
      var currentIndex = 0
      var continue = true
      while(currentNode != null && continue) {
        if (currentIndex == index) {
          val newNode = Node(element, currentNode.previousNode)
          currentNode.previousNode = newNode
          continue = false

        } else {
          currentIndex += 1
          currentNode = currentNode.previousNode
        }
      }
    }

    override def getFirst: String = head.element

    override def getLast: String = tail.element

    override def toArray: Array[String] = {
      val arrayBuffer = new ArrayBuffer[String]()
      var currentNode = head
      while(currentNode != null) {
        arrayBuffer += currentNode.element
        currentNode = currentNode.previousNode

      }
      arrayBuffer.toArray
    }

  }


  val ll = new MyLinkedList
  ll.append("a")
  ll.append("b")
  ll.append("c")
  ll.append("d")

  ll.toArray.foreach(println)
  println("xxxxxxxxxxxxxxxxxxxxxxxx")
  ll.append("z")
  ll.toArray.foreach(println)
  println("xxxxxxxxxxxxxxxxxxxxxxxx")
  ll.addAfter(1, "t")
  ll.toArray.foreach(println)


}
