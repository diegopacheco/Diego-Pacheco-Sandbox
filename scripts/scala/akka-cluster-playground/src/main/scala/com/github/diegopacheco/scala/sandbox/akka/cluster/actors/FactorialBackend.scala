package com.github.diegopacheco.scala.sandbox.akka.cluster.actors

import akka.actor.{Actor, ActorLogging}
import akka.pattern.pipe
import scala.annotation.tailrec
import scala.concurrent.Future

class FactorialBackend extends Actor with ActorLogging {

  import context.dispatcher

  def receive = {
    case (n: Int) =>
      Future(factorial(n)) map { result => (n, result) } pipeTo sender()
  }

  def factorial(n: Int): BigInt = {
    @tailrec def factorialAcc(acc: BigInt, n: Int): BigInt = {
      if (n <= 1) acc
      else factorialAcc(acc * n, n - 1)
    }
    factorialAcc(BigInt(1), n)
  }

}
