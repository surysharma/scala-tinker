
/************************************************************************/
//a) For a given Array buffer with +ve and -ve numbers,
//remove all the -ve numbers except the first one. H
// ow would you do the the same thing in java? Just
// write Pseudocode.

//Imperative style
import scala.collection.mutable.ArrayBuffer
def firstNegativeNum(arrayBuffer: ArrayBuffer[Int])= {

  val resultArrayBuff = new ArrayBuffer[Int]()
  var firstNegativeNum = false
  for (num <- arrayBuffer) {
    if ( num < 0 && !firstNegativeNum) {
      firstNegativeNum = true
      resultArrayBuff += num
    }
    else if (num > 0) {
      resultArrayBuff += num
    }
  }
  (arrayBuffer, resultArrayBuff)
}

val (originalTuple, resultingTuple) = firstNegativeNum (ArrayBuffer(-1,-4,5,-5,-6,3,-8,3,-2,5,8,-3,11))
println("Original list " + (originalTuple))
println("Resulting list " + (resultingTuple))


//Functional style
//TODO

/************************************************************************/

val scores = Map("bob" -> 23, "socs"->2432, "timeo" -> 99)

scores("timeo")
val suryscore = scores + ("sury" -> 232)
scores("socs")
scores.getOrElse("fred", "Entry not found")

scores
suryscore

for ((k,v) <- suryscore)
  println("k=" + k + ",v=" +v)


val tuple = ("sury", 1, 2.0)
tuple _2

val (name, age, _ ) = tuple

age
name
tuple _3
