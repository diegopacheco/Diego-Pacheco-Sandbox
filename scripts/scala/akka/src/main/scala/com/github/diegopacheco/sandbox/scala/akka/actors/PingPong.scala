package com.github.diegopacheco.sandbox.scala.akka.actors

import akka.actor.Actor._
import akka.actor.{ActorRegistry, Actor}
import akka.remote._
import akka.actor._

object PingPong{
  def run = {
     val ping = Actor.actorOf[PingActor]
     ping.start()
     
     val result = ping !! "ping"
     println("result: " + result)
     
     // Kill the actor and restart following the supervisior strategy
     ping ! Kill
     
  }
  def main(args: Array[String]) = run
}