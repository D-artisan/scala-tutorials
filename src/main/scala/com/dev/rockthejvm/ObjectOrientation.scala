package com.dev.rockthejvm

object ObjectOrientation extends App {

  // Class and instance
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat() = println("I am eating")
  }

  val anAnimal = new Animal

  // Inheritance
  class Dog(val name: String) extends Animal // constructor definition

  val aDog = new Dog("Lassie")

  // constructor arguments are not fields: to make a constructor argument a field, you need to put a val before the constructor argument

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // all fields and methods are by default public. can be restricted by using private or protected

    def walk(): Unit
  }
  // Interface = ultimate abstract type. Meaning you can leave everything unimplemented
  trait Carnivore {
      def eat(animal: Animal): Unit
    }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocofile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("chump! chump")

      override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocofile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation | object method argument. Only availabe for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything")
  }

  /*
    class Carnivore_Anonymous_35728 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything")
    }

    val dinosaur = new Carnivore_Anonymous_35728
   */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 54522
    def mySpecialMethod(): Int = 45
    def apply(x: Int): Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { // companions - companion object: has the same name as the class whose name it bears
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things.
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
    case classes: Lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialisation (usually sent over the wire in real world implementations
    - companion with apply
   */
  case class Person(name: String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch { // In Java, we'd say something like catch(Exception e) {...}
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what: useful for ensure files or certain processes are definitely closed.
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // gives us a string

  // Point #1: In Scala, we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
    - works miracles in multithreaded/distributed environments
    - helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list, not a modified version of the original

  // Point #2: Scala is closest to teh OO ideal

}

