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

   */












}

