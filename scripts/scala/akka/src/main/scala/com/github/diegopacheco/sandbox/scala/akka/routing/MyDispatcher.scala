package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.Actor
import akka.actor.Actor._
import akka.routing.Dispatcher

//Our message types
case object Ping
case object Pong

class MyDispatcher extends Actor with Dispatcher {
  //Our pinger and ponger actors
  val pinger = actorOf(new Actor { def receive = { case x => println("Pinger: " + x) } }).start()
  val ponger = actorOf(new Actor { def receive = { case x => println("Ponger: " + x) } }).start()
  //When we get a ping, we dispatch to the pinger
  //When we get a pong, we dispatch to the ponger
  def routes = {
    case Ping => pinger
    case Pong => ponger
  }
}

object MyDispatcherMain{
  def run {
    //Create an instance of our dispatcher, and start it
	val d = actorOf[MyDispatcher].start()

	d ! Ping //Prints "Pinger: Ping"
	d ! Pong //Prints "Ponger: Pong"
	
  }
  def main(args: Array[String]) = run
}