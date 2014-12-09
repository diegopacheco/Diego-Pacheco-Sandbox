package com.github.diegopacheco.sandbox.scala.akka.mailboxes

import akka.actor.Actor
import akka.dispatch.RequiresMessageQueue
import akka.dispatch.BoundedMessageQueueSemantics
import akka.actor.ActorSystem
import akka.actor.Props

/**
    UnboundedMailbox - The default mailbox
    Backed by a java.util.concurrent.ConcurrentLinkedQueue
    Blocking: No
    Bounded: No
    Configuration name: "unbounded" or "akka.dispatch.UnboundedMailbox"
    
    SingleConsumerOnlyUnboundedMailbox
    Backed by a very efficient Multiple Producer Single Consumer queue, cannot be used with BalancingDispatcher
    Blocking: No
    Bounded: No
    Configuration name: "akka.dispatch.SingleConsumerOnlyUnboundedMailbox"
    
    BoundedMailbox
    Backed by a java.util.concurrent.LinkedBlockingQueue
    Blocking: Yes
    Bounded: Yes
    Configuration name: "bounded" or "akka.dispatch.BoundedMailbox"
    
    UnboundedPriorityMailbox
    Backed by a java.util.concurrent.PriorityBlockingQueue
    Blocking: Yes
    Bounded: No
    Configuration name: "akka.dispatch.UnboundedPriorityMailbox"
    
    BoundedPriorityMailbox
    Backed by a java.util.PriorityBlockingQueue wrapped in an akka.util.BoundedBlockingQueue
    Blocking: Yes
    Bounded: Yes
    Configuration name: "akka.dispatch.BoundedPriorityMailbox"
 * 
 */
class SimpleActor extends Actor with RequiresMessageQueue[BoundedMessageQueueSemantics] {
    def receive = {
       case _ => Thread.sleep(5000) ; println("ack")
    }
}

object ActorMailBoxMainApp extends App {
  
   val system = ActorSystem("ActorMailBoxMainApp")
   val actor  = system.actorOf(Props[SimpleActor],"simpleactor")
   
   for ( i <- (1 to 200) ) {
       actor ! i
   }
   
}