package com.github.diegopacheco.sandbox.scala.akka.actor.persistence

import akka.persistence.PersistentView
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.persistence.Update

class MyView extends PersistentView {
 
  override def persistenceId: String = "some-persistence-id"
  override def viewId: String = "some-persistence-id-view"
  
  var state:String = "myState"
  
  def receive:Actor.Receive = {
    case payload if isPersistent =>  println("Journal")
    // handle message from journal...
    case payload                 =>  println("user")
    // handle message from user-land...
  }
  
}

object PersistentViewsApp extends App {
     
    val system = ActorSystem("PersistentViewAS")
    
    val view = system.actorOf(Props[MyView])
    view ! "test"
    view ! Update(await = true)
  
  
}