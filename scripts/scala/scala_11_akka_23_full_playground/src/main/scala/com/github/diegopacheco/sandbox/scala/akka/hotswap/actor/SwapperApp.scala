package com.github.diegopacheco.sandbox.scala.akka.hotswap.actor

import akka.actor.ActorSystem
import akka.event.Logging
import akka.actor.Actor
import akka.actor.Props
import akka.actor.Kill

case object Swap

class Swapper extends Actor {
  
  import context._
  val log = Logging(system, this)
 
  def receive = {
    case Swap =>
      log.info("Hi")
      become({
        case Swap =>
          log.info("Ho")
          unbecome() // resets the latest 'become' (just for fun)
      }, discardOld = false) // push on top instead of replace
  }
}
 
object SwapperApp extends App {
  val system = ActorSystem("SwapperSystem")
  val swap = system.actorOf(Props[Swapper], name = "swapper")
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho
  
  swap ! Kill 
  
}