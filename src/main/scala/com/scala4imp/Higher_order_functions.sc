println("***************Higher order Functions ***********")

def mymap(i: Int, f:Int  => String) = {
  println(f(i))
}

val list = List(1,2,3,5,6,7,8)

for (i <- list) {
  mymap(i, (i) => i.toString)
  mymap(i, (i) => "This is number " + i)
}

list filter(_%2 == 0) map("This is transformed " + _)




def addBy(i: Int) ={

  (str: String) => str + i

}

def mulBy(i: Double) = {
  (x : Double) => x * i
}


val nu1 = mulBy(3)

nu1(5)

val st1 = addBy(40)

st1("Sury age: ")
st1("Happy b'day sury you are ")