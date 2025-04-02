object RecursionExample {
  def A(n: Int): Unit = {
    if (n > 0) {
      println(n)
      A(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val x = 3
    A(x)
  }
}
