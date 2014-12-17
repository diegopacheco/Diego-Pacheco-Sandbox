package com.github.diegopacheco.sandbox.scala.akka.actor.persistence

import akka.persistence.SaveSnapshotFailure
import akka.persistence.SaveSnapshotSuccess
import akka.persistence.Processor
import akka.persistence.SnapshotOffer
import akka.persistence.Persistent
import akka.actor.ActorSystem
import akka.actor.Props
import akka.persistence.Recover
import akka.persistence.SnapshotSelectionCriteria

@deprecated("Processor will be removed. Instead extend `akka.persistence.PersistentActor` and use it's `persistAsync(command)(callback)` method to get equivalent semantics.", since = "2.3.4")
class MyProcessor extends Processor {
  var state: Any = _
 
  def receive = {
    case "snap"                                => saveSnapshot(state)
    case SaveSnapshotSuccess(metadata)         => println("meta: " + metadata)
    case SaveSnapshotFailure(metadata, reason) => println("meta: " + metadata + " reason: " + reason)
    case SnapshotOffer(metadata, offeredSnapshot) => state = offeredSnapshot
    case Persistent(payload, sequenceNr)          => println("persistent")
  }
}

object SnapshotsPersistenceApp extends App {
  
    val system = ActorSystem("SnapshotsAS")
    
    val processor = system.actorOf(Props[MyProcessor])
    
    processor ! "snap"
    
    processor ! 
      Recover(fromSnapshot = SnapshotSelectionCriteria(maxSequenceNr = 457L,maxTimestamp = System.currentTimeMillis))
  
  
    
}