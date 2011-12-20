package com.github.diegopacheco.sandbox.scripts.scala.basic.func

object FuncComposition {
   // Sample of how to build something complex and hard to undersnatnd that 
   // you may get trapped, but its smell far way from here... maybe just
   // avoid compose PERIODO e do simplest high order functions form.
    def run {
         def addUmm(x: String)  = 1
         def addAhem(x: String) = x + " ahem"
         val ummThenAhem = (x: String) => addAhem(x).compose( addUmm )
         println( ummThenAhem.apply("well").apply("well") )
    }
	def main(args: Array[String]) = run
}