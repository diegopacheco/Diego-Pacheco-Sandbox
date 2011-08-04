package com.github.diegopacheco.sandbox.scripts.scala.basic

class any {
	def p(o:Any) = println(o)
}

object AnyMain{
     def main(args : Array[String]) : Unit = {
    		var a = new any
    		a.p("teste")
    		a.p(25)
    		a.p(1.5)
    		a.p(false)
    		a.p( (1 to 10) )
    		a.p( 'C' )
    		a.p( new Object() )
    		a.p( Nil )
    		a.p( null )
     }
}