package com.github.diegopacheco.sandbox.scripts.scala.typesystem

object ScalaTypeSystem {
    def run{
        println("%%% parametric polymorphism ")
        parametric_polymorphism
        
        println("%%% quantification wildcards ")
        quantification_wildcards
    }
    def parametric_polymorphism{
       val lista =  2 :: 1 :: "bar" :: "foo" :: Nil
       println( lista )
       println( lista.head )
       println( lista.tail )
       println( lista(1) )
       
       def drop1[A](l: List[A]) = l.tail
       println( drop1(List(1,2,3)) )
    }
    def quantification_wildcards{
        def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
        println(  hashcodes(Seq("one", "two", "three")) )
    }
	def main(args: Array[String]) = run
} 