def factorialFunction(n: Int): Int =
  if (n <= 1) 1
  else n * factorialFunction(n-1)


print(factorialFunction(5))