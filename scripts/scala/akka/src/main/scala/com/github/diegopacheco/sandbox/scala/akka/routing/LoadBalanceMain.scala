package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor._
import akka.actor.Actor._
import akka.routing.{ LoadBalancer, CyclicIterator }
import akka.dispatch._

//Our message types
case object PingLB
case object PongLB

object LoadBalanceMain {
  def run {

    //A load balancer that balances between a pinger and a ponger
    class MyLoadBalancer extends Actor with LoadBalancer {
      val pinger = actorOf(new Actor { def receive = { case x => println("Pinger: " + x) } }).start()
      val ponger = actorOf(new Actor { def receive = { case x => println("Ponger: " + x) } }).start()

      val seq = new CyclicIterator[ActorRef](List(pinger, ponger))
    }

    val d = actorOf[MyLoadBalancer].start()

    d ! PongLB //Prints "Pinger: Pong"
    d ! PongLB //Prints "Ponger: Pong"
    d ! PingLB //Prints "Pinger: Ping"
    d ! PingLB //Prints "Ponger: Ping"
  }
  def main(args: Array[String]) = run
}