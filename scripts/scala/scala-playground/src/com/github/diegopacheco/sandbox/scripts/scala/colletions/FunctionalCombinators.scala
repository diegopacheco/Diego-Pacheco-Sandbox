package com.github.diegopacheco.sandbox.scripts.scala.colletions

object FunctionalCombinators {
    def run {
       println("### functional: map ")
       map
       
       println("### functional: foreach ")
       foreach
       
       println("### functional: filter ")
       filter
       
       println("### functional: zippers ")
       zippers
       
       println("### functional: partition ")
       partition
       
       println("### functional: find ")
       find
       
       println("### functional: drop ")
       drop

       println("### functional: fold ")
       fold    
       
       println("### functional: flatten ")
       flatten
       
       println("### functional: flatMap ")
       flatMap
       
       println("### functional: combinators ")
       combinators
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
    def foreach{
        var numbers:List[Int] = List(1,2,3)
        numbers.foreach((i: Int) => println(i * 2))
    }
    def filter{
        var numbers:List[Int] = List(1,2,3)       
        println( numbers.filter((i: Int) => i % 2 == 0) )
       
        def isEven(i: Int): Boolean = i % 2 == 0
        println( numbers.filter(isEven _) )
    }
    def zippers{
        var result = List(1, 2, 3).zip(List("a", "b", "c"))
        println(result)
    }
    def partition{
        var result = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).partition((i: Int) => i > 5)
        println(result)
    }
    def find{
        var numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println( numbers.find( (i: Int) => i > 5) )
    }
    def drop{
        println( List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).drop(6) )
        println( List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).dropWhile( (i: Int) => i < 5 ) )
    }
    def fold{
        println( List(1, 2, 3).foldLeft(0)( (m: Int, n: Int) => m - n )  )
        println( List(1, 2, 3).foldRight(0)( (m: Int, n: Int) => m - n ) )
    }
    def flatten{
        println( List(List(1, 2), List(3, 4)).flatten )
    }
    def flatMap{
        val nestedNumbers = List(List(1, 2), List(3, 4))
        var mapa = nestedNumbers.flatMap( x => x.map(_ * 2) )
        println(mapa)
    }    
    def combinators{
        def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
        	numbers.foldRight(List[Int]()) { 
        	   (x: Int, xs: List[Int]) => fn(x) :: xs
        	}
        }        
        println( ourMap(List(1,2,3), i => i * 2 ) )
    }
	def main(args: Array[String]) = run
}
