package com.github.diegopacheco.sandbox.scala.akka.actor.persistence

import akka.actor.ActorSystem
import akka.actor.Props
import akka.persistence.PersistentActor
import akka.persistence.SnapshotOffer

case class Cmd(data:String)
case class Evt(data:String)

case class ExampleState(events:List[String]=Nil) {
  def updated(evt:Evt):ExampleState = copy(evt.data :: events)
  def size:Int = events.length
  override def toString: String = events.reverse.toString
}

class ExamplePersistentActor extends PersistentActor {
  override def persistenceId = "sample-id-1"
 
  var state = ExampleState()
 
  def updateState(event: Evt): Unit = 
     state = state.updated(event)
 
  def numEvents =
    state.size
 
  val receiveRecover: Receive = {
    case evt: Evt                                 => updateState(evt)
    case SnapshotOffer(_, snapshot:ExampleState)  => state = snapshot
  }
 
  val receiveCommand:Receive = {
    case Cmd(data) =>
      persist(Evt(s"${data}-${numEvents}"))(updateState)
      persist(Evt(s"${data}-${numEvents + 1}")) { event =>
        updateState(event)
        context.system.eventStream.publish(event)
      }
      println("Received: " + data)
    case "snap"  => saveSnapshot(state)
    case "print" => println(state)
  }
 
}

object SimplePersistentActorApp extends App {
  
    val system = ActorSystem("PersistentActorSample")
    
    val actor = system.actorOf(Props[ExamplePersistentActor],"persistentActorGeneric")
    
    actor ! Cmd("hello")
    
}