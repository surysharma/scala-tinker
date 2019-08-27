package com.advancescala.implicits.typeclasses

object SimpleEnrichedClassesExample {

   def main(args: Array[String]): Unit = {

  /*
  "hello".toHtmlBoldTag
  <h2>hello</h2>
   */

     trait HtmlConverter[T,R] {
       def toHtmlBoldTag[T]: R
       def toParaTag[T]: R
     }

     implicit class HtmlStringConverter(str: String) extends HtmlConverter[String, String] {
       override def toHtmlBoldTag[String] =  s"<b>$str</b>"
       override def toParaTag[String] = s"<p>$str</p>"
     }
     implicit class HtmlIntConverter(num: Int) extends HtmlConverter[Int, String]{
       def toHtmlBoldTag[Int] = s"<b>$num</b>"
       def toParaTag[Int]  = s"<p>$num</p>"
     }


     println("hello".toHtmlBoldTag)
     println("hello".toParaTag)
     println(1.toHtmlBoldTag)
     println(1.toParaTag)


  }



}
