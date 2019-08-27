import scala.collection.mutable.ArrayBuffer

def toArrayBuff(elem: Int*) = {
  var ab = new ArrayBuffer[Int]()
 var result = ab :: elem.toList
}



val abb = new ArrayBuffer[Int]()

val r1 = abb :: List(1,2,3)

r1 :: List(4,6,7)

println(r1)