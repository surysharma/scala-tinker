import scala.annotation.tailrec
//isSorted

def isSorted[A](array: Array[A])(f:(A, A) => Boolean): Boolean = {

  @tailrec
  def loop(i: Int, result: Boolean): Boolean = i match {

    case i if (i == array.length) => result
    case i if (f(array(i-1), array(i)))  => loop(i+1, true)
    case _ =>  false
  }

  loop(1, false )
}

isSorted(Array(0,2,3,5,7,9))((x, y) => x < y)

isSorted(Array("a", "k", "c"))((x, y) => x.toUpperCase < y.toUpperCase)