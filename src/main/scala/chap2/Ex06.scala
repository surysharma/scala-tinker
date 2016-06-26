package chap2


class Ex06 extends App{

  /*
  6. Write a for loop for computing the product of the Unicode codes of all
  letters in a string. For example, the product of the characters in "Hello"
  is 9415087488L.
   */
  def unicodeWithLoop(str: String) = {
    var result: Long = 1
    for(i <- str) result *= i.toLong
    result

  }

  val result  = unicodeWithLoop("Hello")
  print(result)


  def unicodeWithoutLoop(str: String) = {

    str.map(_.toLong).product

  }

  unicodeWithoutLoop("Hello")

}
