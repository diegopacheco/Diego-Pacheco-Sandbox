package com.github.diegopacheco.sandbox.scala.akka.actors.async

import akka.actor.Actor._
import akka.actor.{ActorRegistry, Actor}
import akka.remote._
import akka.actor._

object PingPong{
  def run = {
     val ping = Actor.actorOf[PingAsyncActor]
     ping.start()
     
     implicit val timeout = Actor.Timeout(100)
     var future = ping ? "ping"
     println("Future Async Rulez: " + future)
     
     future.as[String] match {
     	case Some("pong") => println("Yeah I got Pong!")
     	case _ => println("Sucks, problaly timeout :(")
     }
     
     ping.stop()
     Actor.registry.shutdownAll()
     
  }
  def main(args: Array[String]) = run
}