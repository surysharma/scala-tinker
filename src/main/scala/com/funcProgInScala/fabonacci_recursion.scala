package com.funcProgInScala

import scala.annotation.tailrec

object fabonacci_recursion extends App {

  def fabonacci(index: Int): Int = {
    val num1 = 0
    val num2 = 1
    if (index == 1 || index == 2) index

    else if (index > 2) {

      @tailrec
      def loop(counter: Int, num1: Int, num2: Int): Int = {
        if (counter == index) {
          num2
        } else {
          loop(counter + 1, num2,  num1 + num2)
        }
      }

      loop(2, num2, num1 + num2)
    }
    else{
      throw new Exception("Invalid index value")
    }
  }

  println(fabonacci(7))
  //0,1,2,3,5,8,13
}
