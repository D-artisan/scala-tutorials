package com.dev.rockthejvm

object ObjectOrientation2 extends App {

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    // define methods
    def eat() = println("Animal is eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(name: String) extends Animal {
    override def eat(): Unit = println(s"$name the Dog is eating")
  }

  // constructor arguments are NOT fields: need to put a val before the constructor argument

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // This is called dynamic method dispatch or runtime polymorphism, ensuring the most specific version of the method is executed at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default all classes and their members are public, unless explicitly restricted by adding protected or private
    def walk(): Unit
  }

  // "Interface" = ultimate abstract type
  trait Carnivore {

  }
}
