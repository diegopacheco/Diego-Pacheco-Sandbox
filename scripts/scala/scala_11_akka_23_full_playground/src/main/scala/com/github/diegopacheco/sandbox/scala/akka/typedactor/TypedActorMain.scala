package com.github.diegopacheco.sandbox.scala.akka.typedactor

import scala.concurrent.Future
import akka.actor.ActorSystem
import akka.actor.TypedProps
import akka.actor.TypedActor
import scala.concurrent.ExecutionContext

trait Squarer {
    
    def squareDontCare(i: Int): Unit //fire-forget
 
    def square(i: Int): Future[Int] //non-blocking send-request-reply
 
    def squareNowPlease(i: Int): Option[Int] //blocking send-request-reply
 
    def squareNow(i: Int): Int //blocking send-request-reply
 
    @throws(classOf[Exception]) //declare it or you will get an UndeclaredThrowableException
    def squareTry(i: Int): Int //blocking send-request-reply with possible exception
    
}

class SquarerImpl(val name: String) extends Squarer {
  def this() = this("default")
  def squareDontCare(i: Int): Unit = i * i 
  def square(i: Int): Future[Int] = Future.successful(i * i)
  def squareNowPlease(i: Int): Option[Int] = Some(i * i)
  def squareNow(i: Int): Int = i * i
  def squareTry(i: Int): Int = throw new Exception("Catch me!")
}

object TypedActorMain extends App{
      
    val system = ActorSystem("TypedActorSystem")
    
    val mySquarer:Squarer = TypedActor(system).typedActorOf(TypedProps[SquarerImpl]())
    
    val otherSquarer:Squarer = TypedActor(system).typedActorOf(TypedProps(classOf[Squarer],new SquarerImpl("foo")), "name")
    
    mySquarer.squareDontCare(10)
    
    val oSquare = mySquarer.squareNowPlease(10)
    println(oSquare.get)
    
    val iSquare = mySquarer.squareNow(10)
    println(iSquare)
    
    // other way to do it
    
    implicit val ec = ExecutionContext.Implicits.global
    
    val printIt: PartialFunction[Int, Unit] = {
       case i:Any => println(i)
    }
    
    val fSquare = mySquarer.square(10) 
    fSquare.onSuccess(printIt)
    
    TypedActor(system).poisonPill(otherSquarer)
    
}