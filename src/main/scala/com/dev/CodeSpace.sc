def factorialFunction(number: Int): Int =
  if (number <=1 ) 1
  else number * factorialFunction(number-1)


println(factorialFunction(5))