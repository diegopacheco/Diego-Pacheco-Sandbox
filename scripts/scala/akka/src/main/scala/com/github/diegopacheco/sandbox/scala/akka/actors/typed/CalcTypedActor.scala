package com.github.diegopacheco.sandbox.scala.akka.actors.typed

import akka.actor.TypedActor
import akka.dispatch.Future
import akka.dispatch.Future._

trait Calculator {
   def sum(va:Double,vb:Double):Future[Double]
   def subtract(va:Double,vb:Double):Future[Double]
   def multiply(va:Double,vb:Double):Future[Double]
   def division(va:Double,vb:Double):Future[Double]
}

class CalcTypedActor extends TypedActor with Calculator{
	
   override def sum(va:Double,vb:Double):Future[Double] = future(va + vb)
   override def subtract(va:Double,vb:Double):Future[Double] = future(va - vb)
   override def multiply(va:Double,vb:Double):Future[Double] = future(va * vb)
   override def division(va:Double,vb:Double):Future[Double] = future(va / vb)
  
}