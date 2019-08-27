package com.advancescala.implicits.typeclasses

object EnrichedTypeClassesExample {

   def main(args: Array[String]): Unit = {

     /*
      user1 === user2
      user1 !== user2
      */

     trait StrictEquality[T] {
       def ===(t2: T): Boolean
       def !==(t2: T): Boolean
     }

     implicit class equality(str: String) extends StrictEquality[String] {
       override def ===(t2: String): Boolean = str == t2
       override def !==(t2: String): Boolean = str != t2
     }

     print("a triple equals b:")
     println("a" === "b")

     print("A triple equals A:")
     println( "A" === "A")

     print("c ! triple equals C:")
     println( "c" !== "C")
     print("c triple equals c: ")

     println( "c===c" + "c" !== "c")

     case class User(name: String, age: Int)
     implicit class UseEquality(user1: User) extends StrictEquality[User] {
       override def ===(user2: User): Boolean = user1 == user2
       override def !==(user2: User): Boolean = user1 != user2
     }

     print("User1 triple equals User2:")
     println(User("Sury", 29) === User("Sury", 29))
     print("User1 triple !equals User2:")
     println(User("Sury", 29) != User("sury", 29))


   }



}
