package com.github.diegopacheco.sandbox.scripts.scala.monads

object Monads2FunContinue {
	
	case class Thing[+A](value: A)
		
	case class Thing2[+A](value: A){
		def bind[B](f: A => Thing[B]) = f(value)
	}
  
	def main(args: Array[String]) {
		
		val a = Thing(1)
	  	val b = Thing(2)
	  	println(a)
	  	println(b)
	  
	  	def foo(i: Int) = Thing(i + 1) 
	  	
	  	val c = Thing(1)
	  	val d = foo(c.value) // => Thing(2)
	  	println(c)
	  	println(d)
	  	
	  	def foo2(i: Int) = i + 1
 
	  	val e = 1
	  	val f = foo(e)  // => 2
	  	println(e)
	  	println(f)
	  	
	  	// --------------
	  	println("zzzzzzzzzz")
	  	
	  	def foo3(i:Int) = Thing(i + 1)
 
	  	val h = Thing2(1)
	  	val i = h bind foo3  // => Thing(2)
	  	println(h)
		println(i)
	  	
	}
}