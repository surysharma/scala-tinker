class Point(val x: Int, val y: Int) {

  def +(xInc: Int, yInc: Int) = new Point(x + xInc, y +yInc)
  def +(zoom: Int) = new Point(x * zoom, y * zoom)

  def prettyPrintX = f"The value of ${x}"
  def prettyPrintY = f"The value of ${y}"

}


val point = new Point(2,3)



val incPoint = point + (4,5)
val zoomedPoint = point + 100

incPoint.x
incPoint.y

zoomedPoint.x
zoomedPoint.y

point prettyPrintX

point prettyPrintY

println("***********************************************************")


object Counter {

  private var count = 0

  def increment(x : Int) = count += x

  def reset  = count = 0

  def totalCount = count

}

val counter = Counter

counter totalCount

counter increment 1

counter totalCount

counter increment 1

counter increment 1

counter increment 1

counter totalCount

counter reset

counter totalCount

println("***********************************************************")


