package com.github.diegopacheco.sandbox.scripts.scala.colletions

object FunctionalCombinators {
    def run {
       println("### functional: map ")
       map
       
    }
    def map{
       var numbers:List[Int] = List(1,2,3)
       val result = numbers.map( (i: Int) => i * 2 )
       println(result) 
       
       def addfour(i:Int):Int = i + 4
       val odds = List(1,3,5,7)
       val res  = odds.map(addfour _)
       println(res)
       println( List(1,3,5,7).map( (i: Int) => i + 4 ) )
       
    }    
	def main(args: Array[String]) = run
}
