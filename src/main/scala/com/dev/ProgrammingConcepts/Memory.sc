var x:Int = 10
x += 1


def B(k: Int):Unit =
  println(k)

def A(a: Int): Unit =
  println(B(2 * a))

A(x)