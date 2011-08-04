package com.github.diegopacheco.sandbox.scripts.scala.collections.par

class ParallelCollections {
	
    def calc(toBeProcessed:List[Int]) = {
        toBeProcessed.par.map( i => process(i) )
    }
    
    def process(i:Int) = {
        val r = i * 2
        Thread.sleep(1000)
        printf(" %d X 2 == %d \n", i, r)
        r
    }        
}

object AnyMainS2{
     def main(args : Array[String]) : Unit = {
         var pc = new ParallelCollections
         pc.calc( List(1,2,3,4,5,6,7,8,9,10) )
     }
}