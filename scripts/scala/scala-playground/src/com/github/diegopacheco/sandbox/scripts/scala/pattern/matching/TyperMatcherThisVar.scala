package com.github.diegopacheco.sandbox.scripts.scala.pattern.matching

object TyperMatcherThisVar extends App {
	
	class Sample{
		val max = 100
		val MIN = 0
		
		def process(input:Int){
			input match{
				case this.max => println("This max 100")
				case MIN => println("MIN 0")
				case _ => println("???")
			}
		}
	}
	
	new Sample().process(100)
	new Sample().process(0)
	new Sample().process(2)
  
}