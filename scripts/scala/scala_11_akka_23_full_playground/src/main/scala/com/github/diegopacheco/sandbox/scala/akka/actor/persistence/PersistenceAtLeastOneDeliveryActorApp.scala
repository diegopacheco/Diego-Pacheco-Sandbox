package com.github.diegopacheco.sandbox.scala.akka.actor.persistence

import akka.actor.{ Actor, ActorPath }
import akka.persistence.AtLeastOnceDelivery
import akka.persistence.PersistentActor
import akka.actor.ActorSystem
import akka.actor.Props

case class Msg(deliveryId:Long, s:String)
case class Confirm(deliveryId: Long)
 
sealed trait Evt1
case class MsgSent(s:String) extends Evt1
case class MsgConfirmed(deliveryId:Long) extends Evt1

class MyPersistentActor2(destination:ActorPath)
  extends PersistentActor with AtLeastOnceDelivery {
 
  def receiveCommand:Receive = {
    case s:String            => persist(MsgSent(s))(updateState)
    case Confirm(deliveryId) => persist(MsgConfirmed(deliveryId))(updateState)
  }
 
  def receiveRecover:Receive = {
    case evt:Evt1 => updateState(evt)
  }
 
  def updateState(evt:Evt1): Unit = evt match {
    case MsgSent(s)               => deliver(destination, deliveryId => Msg(deliveryId, s))
    case MsgConfirmed(deliveryId) => confirmDelivery(deliveryId)
  }
  
}

class MyDestination extends Actor {
  def receive = {
    case Msg(deliveryId, s) => sender() ! Confirm(deliveryId)
  }
}

object PersistenceAtLeastOneDeliveryActorApp extends App {
    
    val system = ActorSystem("PersistentViewAS")
    
    val a = system.actorOf(Props[MyDestination])
    
    val per = system.actorOf(Props(classOf[MyPersistentActor2], a.path))
    
    per ! "test"
    per ! MsgSent("ok")
  
}