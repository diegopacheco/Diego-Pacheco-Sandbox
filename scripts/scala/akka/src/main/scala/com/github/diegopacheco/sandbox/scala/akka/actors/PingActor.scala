package com.github.diegopacheco.sandbox.scala.akka.actors

import akka.actor.Actor
import akka.event.EventHandler

class PingActor extends Actor {
  def receive = {
    case "ping" => 
      	println("ping received.")
      	EventHandler.info(this, "received ping")
      	self.reply("pong")
    case _ => 
      	EventHandler.info(this, "received unknown message: ")
  }
}