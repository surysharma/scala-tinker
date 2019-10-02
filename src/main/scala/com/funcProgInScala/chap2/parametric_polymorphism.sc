def partial1[A, B, C](a: A, f:(A, B) => C): B => C = {
  b => f(a, b)
}

partial1(2, (x: Int, y: String) => x.toString + y)


def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
  a => (b => f(a, b))
}

def f: (Int, Double) => String = {
  (i, doub) => (i + doub).toString
}

curry(f)


def uncurry[A, B, C](f: A => (B => C)): (A, B) => C = {
  (a,b) => f(a)(b)
}

def compose[A, B, C](f: B => C, g: A => B): A => C = {
  (a: A) => f(g(a))
}
