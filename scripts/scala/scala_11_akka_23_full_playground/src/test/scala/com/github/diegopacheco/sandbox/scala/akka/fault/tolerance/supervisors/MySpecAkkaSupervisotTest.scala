package com.github.diegopacheco.sandbox.scala.akka.fault.tolerance.supervisors

import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.ActorRef
import akka.testkit._
import akka.testkit.ImplicitSender
import akka.testkit.EventFilter
import akka.testkit.TestEvent._
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpecLike

class Supervisor extends Actor {
    
    import akka.actor.OneForOneStrategy
    import akka.actor.SupervisorStrategy._
    import scala.concurrent.duration._
 
    override val supervisorStrategy =
      OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
         case _: ArithmeticException      => Resume
         case _: NullPointerException     => Restart
         case _: IllegalArgumentException => Stop
         case _: Exception                => Escalate
      }
 
      def receive = {
         case p: Props => sender() ! context.actorOf(p)
      }
      
  }

class Child extends Actor {
    var state = 0
    def receive = {
      case ex:Exception => throw ex
      case x:Int        => state = x
      case "get"        => sender() ! state
    }
}

class MySpecAkkaSupervisotTest(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {
 
  def this() = this(ActorSystem("MySpec"))
 
  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }
 
  "An Child actor" must {
    
    "send messages and get right things back" in {
       
       val supervisor = system.actorOf(Props[Supervisor], "supervisor")
       
      supervisor ! Props[Child]
      val child = expectMsgType[ActorRef]
      child ! 42
      child ! "get"
      expectMsg(42)
    
     }
     
     "send messages and get Exception and supervisor works :-) " in {
       
       val supervisor = system.actorOf(Props[Supervisor], "supervisor2")
       
        supervisor ! Props[Child]
        val child = expectMsgType[ActorRef]
        child ! new NullPointerException
        child ! 42
        child ! "get"
        expectMsg(42)
    
     }
    
  }
  
}
