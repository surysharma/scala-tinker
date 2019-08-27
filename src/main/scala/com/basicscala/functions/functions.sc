
/*
Tail recursive fn. String concat
 */
def stringConcat(item: String, times: Int): String = {
  def stringConcatWithAcc(times: Int, accum: String): String = {
    if (times == 0) accum
    else stringConcatWithAcc(times - 1, (item + accum))
  }
  stringConcatWithAcc(times, "")
}

stringConcat("H", 5)


/*
Trail recursive factorial
 */
def factorial(num: Int): Int ={
  def factorialWithRec(num: Int, accum: Int): Int = {
    if (num == 1) accum
    else factorialWithRec(num - 1, num * accum)
  }
  factorialWithRec(num, 1)
}

factorial(5)

/*
TODO: Fabonacci

1,1,2, 3
*/


/*
TODO: IsNumberPrime
 */


/*
1. Write fn that takes two Strings and return a string
 */

val concatinator: (String, String) => String = (v1, v2) => v1 + v2

println(concatinator("a", "b"))

/*
2. Write a predicate that takes two args and returns a boolean.
 */
trait MyMatcher[A,B] {
  def filter(initialList: List[A], predicate: A => B): List[A]
}
object TestMatcher extends MyMatcher[String, Boolean] {
  override def filter(initialList: List[String], predicate: String => Boolean): List[String] = initialList.filter(predicate)
}

val doubler: Int => Int = (x: Int) => x * 2
/*
3. Write a fn that takes another fn which takes an int and returns an int.
 */
//TODO
//val funky: () => Function1(Int => Int =