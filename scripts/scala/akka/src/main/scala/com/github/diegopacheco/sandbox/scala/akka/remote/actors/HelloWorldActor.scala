package com.github.diegopacheco.sandbox.scala.akka.remote.actors

import akka.actor.Actor._
import akka.actor._

class HelloWorldActor extends Actor {
  def receive = {
    case "Hello" =>
      println("[server] Received Hello, sending: World")
      self.reply("World")
  }
}

