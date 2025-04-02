package com.dev.fpinscala

object code2 extends App {
  class Cafe {
    def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
      val cup = new Coffee()
      p.charge(cup.price)
      cup
    }
  }

  class CreditCard

  trait Payments {
    def charge(price: Double): Unit
  }

  abstract class SimulatedPayments extends Payments {
    def charge(cc: CreditCard, price: Double): Unit = {
      print("charging " + price + " to " + cc)
    }
  }

  class Coffee {
    val price: Double = 2.0
  }

  val cc = new CreditCard()
  val p = new Payments {
    override def charge(price: Double): Unit = ???
  }
  val cafe = new Cafe()
  val cup = cafe.buyCoffee(cc, p)
}
