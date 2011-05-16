package com.github.diegopacheco.sandbox.scripts.scala.basic

import scala.reflect._

/**
 * Class with constructor and more fun with Scala
 * @author Diego Pacheco
 *
 */
class BeanShort(
	@BeanProperty var name:String = "Nothing",	
  	@BeanProperty var steps:List[String] = List("ZERO"),
  	@BeanProperty var args:Map[Int,String] = Map(1 -> "zero")
){
  override def toString() : String = "Name: " + getName() + ", Args: " + getArgs() + ",Steps: " + getSteps()	
}

object bean2short {
  def main(args : Array[String]) : Unit = {
	   var b =  new BeanShort( name = "Diego Pacheco" )
       printf("Object result: %s",b)
  }
}
