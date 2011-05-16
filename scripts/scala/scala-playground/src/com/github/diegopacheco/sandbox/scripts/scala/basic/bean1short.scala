package com.github.diegopacheco.sandbox.scripts.scala.basic

import scala.reflect._

/**
 * Scala veryshort version of bean1 using really nice Scala syntax Suggar
 * 
 * @author Diego Pacheco
 *
 */
object bean1short {
  
	@BeanProperty var name:String = null	
  	@BeanProperty var steps:List[String] = null
  	@BeanProperty var args:Map[Int,String] = null
  	
  	override def toString() : String = "Name: " + getName() + ", Args: " + getArgs() + ",Steps: " + getSteps()
   	
    def main(args : Array[String]) : Unit = {
	   var b = bean1short;
       b.name = "Diego Pacheco"
       b.steps = List("Passo 1", "Passo 2", "Passo 3")
       
       var margs = Map(1 -> "Diego", 2 -> "Scala", 3 -> "Functional", 4 -> "Rocks")
       b.setArgs( margs )       
       
       printf("Object result: %s",b)
    }
}
