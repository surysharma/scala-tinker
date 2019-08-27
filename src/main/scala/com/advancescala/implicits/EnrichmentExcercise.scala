package com.advancescala.implicits

object EnrichmentExcercises {

   def main(args: Array[String]): Unit = {

  /*
  1. Enrich the string class
  "1".asInt
  "abc".encrypt
*/

     implicit class StringEnricher(str: String) {
       def asInt: Int = Integer.parseInt(str)
       def encrypt(i: Int): String =  str.map(ch => (ch+i).asInstanceOf[Char])
     }

     println("3".asInt)
     println("abc".encrypt(5))


  }

/*
   2. Enrich the Int class
    50.times(function)

    3 * List(1,2) => List(1,2,1,2,1,2)
 */

  implicit class IntEnricher(i: Int) {
    def times(fn: Int => Int) = fn(i)

    def *[T](lst: List[T]) : List[T] = {

      var temp : List[T]= List()

      for ( _ <- 0 to i) {
        temp = temp ++ lst
      }

      temp
    }
  }

  println(50 times (3 * _))


  println (2 * List(1,2))

}
