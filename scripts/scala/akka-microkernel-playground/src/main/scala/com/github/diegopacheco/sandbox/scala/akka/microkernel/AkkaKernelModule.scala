package com.github.diegopacheco.sandbox.scala.akka.microkernel

import akka.actor.{ Actor, ActorSystem, Props }
import akka.kernel.Bootable

case object Start

class WorldActor extends Actor {
  def receive = {
    case message:String => sender() ! (message.toUpperCase + " world!")
  }
}

class HelloActor extends Actor {

  val worldActor = context.actorOf(Props[WorldActor])

  def receive = {
    case Start => worldActor ! "Hello"
    case message: String =>
      println("Received message '%s'" format message)
  }
}

class HelloKernel extends Bootable {

  val system = ActorSystem("kernelAS")

  def startup = {
      system.actorOf(Props[HelloActor]) ! Start
  }

  def shutdown = {
      system.shutdown()
  }
}