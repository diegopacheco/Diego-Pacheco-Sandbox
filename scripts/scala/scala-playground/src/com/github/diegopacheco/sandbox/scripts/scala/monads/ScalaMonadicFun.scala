package com.github.diegopacheco.sandbox.scripts.scala.monads

// Get rid of IFS and get rid of nulls
object ScalaMonadicFunMain {
	def main(args: Array[String]) {
		
		def firstName(id:Int):Option[String] = None
		def lastName(id:Int):Option[String]  = Option("Pacheco")
		
		def fullName(id:Int):Option[String] = {
			Some( firstName(id) + " " + lastName(id) )
		}
		
		val result = fullName(1)
		println( result.get )
	  
	}
}
