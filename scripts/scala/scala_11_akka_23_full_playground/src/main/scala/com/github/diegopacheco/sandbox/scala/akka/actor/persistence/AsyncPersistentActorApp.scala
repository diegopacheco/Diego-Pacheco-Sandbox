package com.github.diegopacheco.sandbox.scala.akka.actor.persistence

import akka.persistence.PersistentActor
import akka.actor.ActorSystem
import akka.actor.Props

/**
 * 
 * PersistentActor: 
 * 
 *  Is a persistent, stateful actor. It is able to persist events to a journal and can react to them in a thread-safe manner.
 *  It can be used to implement both command as well as event sourced actors. When a persistent actor is started or restarted, 
 *  journaled messages are replayed to that actor, so that it can recover internal state from these messages.
   
   PersistentView: 
     A view is a persistent, stateful actor that receives journaled messages that have been written by another persistent actor.
     A view itself does not journal new messages, instead, it updates internal state only from a persistent actor's replicated message stream.
   
   AtLeastOnceDelivery:
    
      To send messages with at-least-once delivery semantics to destinations, also in case of sender and receiver JVM crashes.
   
   Journal: 
   
       A journal stores the sequence of messages sent to a persistent actor. An application can control which messages are journaled and which are received by the persistent actor without being journaled. The storage backend of a journal is pluggable. The default journal storage plugin writes to the local filesystem, replicated journals are available as Community plugins.
   
   Snapshot store: 
       
       A snapshot store persists snapshots of a persistent actor's or a view's internal state. Snapshots are used for optimizing recovery times. 
       The storage backend of a snapshot store is pluggable. The default snapshot storage plugin writes to the local filesystem.
 *  
 */
class MyPersistentActor extends PersistentActor {
 
  override def persistenceId = "my-stable-persistence-id"
 
  def receiveRecover:Receive = {
    case _ => println("Sorry, no recover logic coded. ") // handle recovery here
  }
 
  def receiveCommand:Receive = {
    case c: String => {
      sender() ! c
      persistAsync(s"evt-$c-1") { e => sender() ! e }
      persistAsync(s"evt-$c-2") { e => sender() ! e }
      println("receive and return and persiste: " + c)
    }
  }
}

object AsyncPersistentActorApp extends App {
    
    val system = ActorSystem("AsyncPersistentActorAS")
    
    val actor = system.actorOf(Props[MyPersistentActor],"asyncActorPersistent")
    
    actor ! "SomeString"
    actor ! "a"
    actor ! "b"
  
}