package com.dev.rockthejvm

object Basics extends App {
  // defining a value
  // Regular types: Int, Boolean, Char, Double Float, String
  val clientNumber: Int = 42
  val isClientSwedish = false
  val clientName = "Qweku"
  val clientAddress = "House 55, North Wales"
  val statement = s"${clientName} lives at ${clientAddress}"
  println(statement)

  // Expressions: structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (clientNumber > 43) 56 else 999
  val chainedIfExpression =
    if (clientNumber > 43) 56
    else if (clientNumber < 0) -2
    else if (clientNumber > 999) 78
    else 0

  // code blcoks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def thisFunction(x: Int, y: String): String = {
    y + " " + x
  }
  println(thisFunction(5, "hundred"))

  // recursive functions
  def factorialFunction(n: Int): Int =
    if (n <= 1) 1
    else n * factorialFunction(n-1)

  val factorialOfFive = factorialFunction(5)
  println(f"The factorial of 5 is ${factorialOfFive}")

// In Scala, we don't use loops or iteration, we use RECURSION!


  // Unit type: no meaningful value, ie. "void" in other languages
  // type of SIDE EFFECTS
  println("Say something") // print statements return Unit

  def thatFunctionReturnsUnit(name: String, age: Int): Unit =
    println(f"${name} is ${age} years old")

  thatFunctionReturnsUnit("Daniel", 88)

}
