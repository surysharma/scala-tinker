package chap2

class Ex01 extends App{
  /*
1. The signum of a number is 1 if the number is positive,
   –1 if it is negative, and 0 if it is zero.
   Write a function that computes this value.
 */
  def signum(num: Int) =  if (num > 0) 1 else if (num < 0) -1 else 0
  signum(0)
  signum(23)
  signum(-1)
}
