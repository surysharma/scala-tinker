/*
Using unapply method() instead of having condition guards.
 */

val i: Int=44

object IsEven {
  def unapply(i: Int): Boolean = i % 2 == 0
}
object IsOdd {
  def unapply(i: Int): Boolean = i % 2 != 0
}

val result = i match {
  case IsEven() => "Even number"
  case IsOdd() => "Odd number"
}


/*
Infix notation for pattern matching
*/

case class Or[A, B](a: A, b: B)

val result1 = Or(2, "TWO")
val result2 = result1 match {
  case 2 Or "TWHO" =>
  case _ =>
}


