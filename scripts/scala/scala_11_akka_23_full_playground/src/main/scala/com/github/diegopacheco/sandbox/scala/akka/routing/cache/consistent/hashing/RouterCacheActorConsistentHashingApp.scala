package com.github.diegopacheco.sandbox.scala.akka.routing.cache.consistent.hashing

import akka.actor.Actor
import akka.routing.ConsistentHashingPool
import akka.routing.ConsistentHashingRouter.ConsistentHashable
import akka.routing.ConsistentHashingRouter.ConsistentHashMapping
import akka.routing.ConsistentHashingRouter.ConsistentHashableEnvelope
import akka.routing.FromConfig
import akka.actor.Props
import akka.actor.ActorSystem
import akka.actor.ActorRef
import akka.routing.ConsistentHashingPool
import com.github.diegopacheco.sandbox.scala.akka.util.Try

case class Evict(key: String)
case class Entry(key: String, value: String)
case class Get(key: String) extends ConsistentHashable {
  override def consistentHashKey:Any = key
}

class Cache extends Actor {
  var cache = Map.empty[String, String]
 
  def receive = {
    case Entry(key, value) => cache += (key -> value) ; println("add " + key + " - " + "value: " + value)
    case Get(key)          => sender() ! cache.get(key) ; println("get " + key)
    case Evict(key)        => cache -= key ; println("evit: " + key)
  }
  
}

object RouterCacheActorConsistentHashingApp extends App {
    
  def hashMapping:ConsistentHashMapping = {
      case Evict(key) => key
  }
  
  val system = ActorSystem("RouterCacheActorConsistentHashingAS")
  
  val cacheActor:ActorRef =  system.actorOf(ConsistentHashingPool(2, hashMapping = hashMapping).
                              props(Props[Cache]), name = "cache")
  
   Try.it() { () =>
       cacheActor ! ConsistentHashableEnvelope(message = Entry("hello", "HELLO"), hashKey = "hello")
       cacheActor ! ConsistentHashableEnvelope(message = Entry("hi", "HI"), hashKey = "hi")
       
       cacheActor ! Get("hello")
       cacheActor ! Get("hi")
       
       cacheActor ! Evict("hi")
       cacheActor ! Get("hi")
   }
  
}