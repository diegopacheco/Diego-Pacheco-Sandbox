package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor._

class DummyActorFrontend extends Actor {

  val backend = context.actorOf(Props[DummyActorBackend], name = "DummyActorBackend")

  def receive = {
    case StartUpCluster      => println("Booting up: Frontend [{}] Backend [{}]",self.path, backend.path)
    case o:SimpleTextMessage => println("DummyActorFront received: " + o.text) ; backend ! o;
    case d:DeadLetter        => println("Dummy Received a DeadLetter: " + d)
  }
}

class DummyActorBackend extends Actor {
  def receive = {
    case o:SimpleTextMessage => println("DummyActorBackend received: " + o.text) ;
    case d:DeadLetter => println("Dummy Received a DeadLetter: " + d)
  }
}
