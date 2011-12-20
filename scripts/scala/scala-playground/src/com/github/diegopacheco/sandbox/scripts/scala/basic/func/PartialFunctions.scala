package com.github.diegopacheco.sandbox.scripts.scala.basic.func

object PartialFunctions {
    def run{
        
        val one: PartialFunction[Int, String] = { case 1 => "one" }
        println( one.isDefinedAt(1) )
        println( one.isDefinedAt(2) )
        
        println( one(1) )
        
        try{
        	println( one(2) )
        }catch{
           case e:MatchError => println( e.getMessage())
        }       
        
    }
	def main(args: Array[String]) = run
}