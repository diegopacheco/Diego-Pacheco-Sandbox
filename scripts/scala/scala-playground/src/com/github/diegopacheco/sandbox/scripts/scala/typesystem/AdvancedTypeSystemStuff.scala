package com.github.diegopacheco.sandbox.scripts.scala.typesystem

object AdvancedTypeSystemStuff {
    def run{
       println("@@@ implicits")
       implicits 
       println("@@@ implicit evidence")
       implicit_evidence
       println("@@@ generic views")
       generic_views
       println("@@@ structural types")
       structural_types
       println("@@@ abstract type members")
       abstract_type_members
    }
    def implicits{
        println("123")
        println(123)
        
        // without this implicity function lines 15, 16 and 20 won't work!
        implicit def strToInt(x: String) = x.toInt
        
        val y:Int = "123"
        println( math.max("123", 111) )
        
        // Implicity working with generics as well
        class Container[A <% Int] { def addIt(x: A) = 123 + x }
        println( (new Container[String]).addIt("123"))
        println( (new Container[Int]).addIt(123) ) 
        
    }
    def implicit_evidence{
       class Container[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }
       println( (new Container(123)).addIt   )
       
       // The line 31 wont compile because the lack of evidence
       //println( (new Container("123")).addIt )
    }
    def generic_views{
    	println( List(1,2,3,4).min )
    	println( List(1,2,3,4).min(new Ordering[Int]{ def compare(a: Int, b: Int) = b compare a }) )
    }
    def structural_types{
        //BEWARE: Implementation uses Reflection, so use with wisdom.
        def foo(x: { def get: Int }) = 500 + x.get
        println( foo(new { def get = 10 }) )     
    }
    def abstract_type_members{
        trait Foo { 
            type A 
            val x:A 
            def getX:A = x 
        }
        println( (new Foo { type A = Int; val x = 123 }).getX  )
        println( (new Foo { type A = String; val x = "hey" }).getX  )
    }
	def main(args: Array[String]) = run
}