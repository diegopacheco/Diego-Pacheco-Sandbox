package com.github.diegopacheco.sandbox.scripts.scala.basic

object ReduceMain {
    
 def sum(args: Int*) = args.reduceLeft(_+_)
    
 def main(args : Array[String]) : Unit = {
   println ( (1 to 2).reduceLeft(_+_) ) // 3 - sum all elements
   println ( (1 to 3).map( x=> x*x ) ) // 1, 4, 9 - multiply all items trought a annonimous func
   println ( (1 to 3).map(2*) ) // 2, 4, 6 - Multiply all elements by 2
   
   println ( ReduceMain.sum(1,4,1)  ) // 6 - sum all elements
   
   println ( 1 until 9 ) // Range(1, 2, 3, 4, 5, 6, 7, 8)
   
 }
}