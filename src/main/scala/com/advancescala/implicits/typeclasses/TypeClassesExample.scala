package com.advancescala.implicits.typeclasses

object TypeClassesExample {

   def main(args: Array[String]): Unit = {

       trait InventoryManager[T] {
         def addItems(items: List[T])
         def removeItems(items: List[T])
         def showItems
       }
       object InventoryManager {
         def apply[T](implicit inventoryManager: InventoryManager[T]) = inventoryManager
       }


       case class Car(name:String, model: String, year: Int, milage: Int)

       implicit object CarInventoryManager extends InventoryManager[Car] {
         override def addItems(items: List[Car]): Unit = println("Cars added:" + items)

         override def removeItems(items: List[Car]): Unit = println("Cars removed:" + items)

         override def showItems = println("Cars removed:")
       }

     implicit object ToothPasteInventoryManager extends InventoryManager[ToothPaste] {
         override def addItems(items: List[ToothPaste]): Unit = println("ToothPaste added:" + items)

         override def removeItems(items: List[ToothPaste]): Unit = println("ToothPaste removed:" + items)

         override def showItems = println("ToothPaste removed:")
       }

     val carInv: InventoryManager[Car] = InventoryManager[Car]
       carInv.addItems(List(
         Car("tesla", "P100D", 2019, 0),
         Car("tesla", "P100D", 2018, 100),
         Car("tesla", "P100D", 2015, 50000)
       ))

       carInv.showItems

     carInv.removeItems(List(Car("tesla", "P100D", 2019, 0)))


     case class ToothPaste(name: String)

     val pasteInv = InventoryManager[ToothPaste]

     pasteInv showItems

     pasteInv removeItems List(ToothPaste("Collgage"))

  }



}
