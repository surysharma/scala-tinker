package chap2

/**
  * Created by sureshsharma on 25/06/2016.
  */
class Ex04 extends App{

  /*
  4. Write a Scala equivalent for the Java loop
  for (int i = 10; i >= 0; i--) System.out.println(i);
   */

  (0 to 10).reverse.foreach(println)

}
