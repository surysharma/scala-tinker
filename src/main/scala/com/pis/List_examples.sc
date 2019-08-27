val fruits = "Banana" :: "Pears" :: "Mango" :: "Apple" :: Nil

fruits head

fruits tail

//val List(a,b,c, _)  = fruits

val a :: b:: rest = fruits

a
b
rest

implicit def strToInt(str: String) = str.size

val i  = 2 * "Santa"