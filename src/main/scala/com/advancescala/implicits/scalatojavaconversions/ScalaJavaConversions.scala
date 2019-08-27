import java.util.Optional

object ScalaJavaConversions extends App {

  import scala.collection.JavaConverters._
  import java.{util => ju}
  val javaSet: ju.Set[Int] = new ju.HashSet[Int]()

  (1 to 5).foreach(javaSet.add)

  val scalaSet = javaSet.asScala



  val scalaImmList= List(1,2,3)
  val javaImmList = scalaImmList.asJava

  println(scalaImmList eq javaImmList.asScala)


  val optSclaInt: Option[Int] = Some(1)

  import java.{util => ju}
  implicit class Converter[+T](op: Option[T]) {
     def asJavaOptional[B >: T]: Optional[B] = {
      ju.Optional.of(op.get)
    }

  }
  implicit class ConverterToScala[+T](op: ju.Optional[T]) {
     def asScalaOptional[B >: T]: Option[B] = {
      Some(op.get)
    }

  }

  private val javaOptional: Optional[Int] = optSclaInt.asJavaOptional
  println(javaOptional)

  private val scalaOptional = javaOptional.asScalaOptional
  println(scalaOptional)

}