package com.advancescala.generics.mutable

import scala.collection.mutable.ArrayBuffer

object MyMutableLinkedList extends App {

  /*
  A simple mutable linked list of type String.
   */
  trait MyLL {
    def append(element: String)
    def delete(element: String)
    def addAfter(index: Int, element: String)
    def getFirst: String
    def getLast: String
    def toArray: Array[String]
  }
  case class Node(element: String, var previousNode: Node = null)
  class MyLinkedList extends MyLL {

    private var head: Node = null
    private var tail: Node = null
    private var nextNode: Node = null

    override def append(element: String): Unit = {
      if (head == null) {
        head = Node(element)
        tail = head
      }else {
        nextNode = head
        head = Node(element, nextNode)
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

    override def delete(element: String): Unit = {

      if (head ==  null) return

      if (head.element == element){
        head = head.previousNode
        return
      }

      var previousNode = head
      var currentNode = head.previousNode
      while (currentNode != null) {
        if (currentNode.element == element) {
          previousNode.previousNode = currentNode.previousNode
          currentNode = null
        } else {
          previousNode = currentNode
          currentNode = currentNode.previousNode
        }
      }
    }

  }


  val ll = new MyLinkedList
  ll.append("a")
  ll.append("b")
  ll.append("c")
  ll.append("d")

  ll.toArray.foreach(println)

  append("e")
  addAfter(2, "t")
  delete("a")
  delete("b")
  delete("t")
  delete("d")
  delete("c")
  delete("z")


  def append(item: String) = {
    println(s"APPEND:${item} xxxxxxxxxxxxxxxxxxxxxxxx")
    ll.append("z")
    ll.toArray.foreach(println)
  }


  def addAfter(index: Int, item: String) = {
    println(s"ADD After: ${item} xxxxxxxxxxxxxxxxxxxxxxxx")
    ll.addAfter(1, item)
    ll.toArray.foreach(println)
  }

  def delete(item: String) = {
    println(s"DELETE: ${item} xxxxxxxxxxxxxxxxxxxxxxxx")
    ll.delete(item)
    ll.toArray.foreach(println)
  }

}
