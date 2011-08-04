package com.github.diegopacheco.sandbox.scripts.scala.basic

class Filter {
    def filterit():Seq[Int] = {
    	var result = (1 to 5) filter { _%2 == 0 } map { _*2 }
    	println(result)
    	result
    }	
}

object FilterMain{
     def main(args : Array[String]) : Unit = {
        val f = new Filter
        f.filterit
     }
}