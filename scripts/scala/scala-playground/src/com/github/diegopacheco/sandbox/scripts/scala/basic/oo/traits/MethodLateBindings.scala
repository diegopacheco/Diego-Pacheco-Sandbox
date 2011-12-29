package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits
import java.io.StringWriter

object MethodLateBindings extends App {
	
	abstract class Writer{
		def writeMessage(message:String):String 
	}
	
	trait LowercaseWritter extends Writer{
	   abstract override def writeMessage(message:String) =
		   super.writeMessage(message.toLowerCase())
	}
	
	trait XWritter extends Writer{
	   abstract override def writeMessage(message:String) =
		   super.writeMessage("X => " + message)
	}
	
	class StringWriterDelegator extends Writer{	   
	   def writeMessage(message:String) = message
	   override def toString():String = "MyOwnToStringIsBetter"	  
	}
	
	val myWritter = new StringWriterDelegator with LowercaseWritter with XWritter
	println( myWritter.writeMessage("Scala Traits with LATE Method BINDINGS ARE AWESOME") )
  
}