package com.github.diegopacheco.sandbox.scripts.scala.clojure

// ONLY the * will be printed
object PlayWithItAFunc {
	def main(args: Array[String]) {
		( { () => println("1") } )
		( { () => println("2*") } )()
		( () => println("3") )
		( () => println("4*") )()
		() => println("5")		
	}
}