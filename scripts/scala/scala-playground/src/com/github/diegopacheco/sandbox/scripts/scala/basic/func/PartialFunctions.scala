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
        
         
        val two:   PartialFunction[Int, String]  =  { case 2  => "two"    }
        val three: PartialFunction[Int, String]  =  { case 3  => "three"  }
        val others: PartialFunction[Int, String] =  { case _  => "others" }
        
        val switch = two orElse three orElse others
        println( switch(2) )
        println( switch(3) )
        println( switch(4) )
        
    }
	def main(args: Array[String]) = run
}