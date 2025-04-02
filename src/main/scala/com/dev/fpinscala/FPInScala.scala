package com.dev.fpinscala

object FPInScala extends App {

  class Cafe {
    def buyCoffee(cc: CreditCard): Coffee = {
      val cup = new Coffee()
      cc.charge(cup.price)
      cup
    }
  }

  class CreditCard {
    def charge(price: Double): Unit = {
      println("charging " + price)
    }
  }

  class Coffee {
    val price: Double = 2.0
  }

  val cc = new CreditCard()
  val cafe = new Cafe()
  val cup = cafe.buyCoffee(cc)
}
