package chap2

/**
  * Created by sureshsharma on 25/06/2016.
  */
class Ex05 extends App{

  /*
  5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
   */
  def countdown(n: Int)  {
    for(i <- n.to(0, -1)) println(i)
  }

  countdown(10)

}
