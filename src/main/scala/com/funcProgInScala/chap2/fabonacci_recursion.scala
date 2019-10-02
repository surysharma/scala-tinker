package com.funcProgInScala.chap2

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


  val fab = (index: Int) => {

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

  def display(str: String, i: Int, f: Int => Int) {
    println(str + f(i))
  }
  display("The fabonacci number with index is ", 7, fabonacci)
  display("The literal fab number with index is ", 7, fab)
  //0,1,2,3,5,8,13

  //absVal(-5)
}
