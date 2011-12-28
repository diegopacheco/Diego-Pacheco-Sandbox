package com.github.diegopacheco.sandbox.scripts.scala.monads

object SimpleSampleMonadic {

  def foo(bar:String) = {
    ({ () => println(bar) })()
    ({ () => bar.length   })()
  }

  def foo2(bar:String) = {
	 ( () => println(bar) )() -> ( () => bar.length )() 
  } 
  
  def foo3() = {
	 println("******")
     ( () => print("Scala") )() -> ( () => print(" Rocks") )() 
  }
  
  def funcMonadic[A](f1: () => A) = new {
	 def andThen28[B](f2: () => B) = { f1() ; f2() }
  }
  
  def monadic[A](f1: () => A) = new {
	 def ->[B](f2: () => B) = { f1() ; f2() }
  }
  
  def bigMonadicPipe() = {
      monadic( () => print("A") ) -> ( () => print("B") ) -> ( () => print("C") ) -> ( () => print("D") )() 
  }
  
  def main(args:Array[String]) {
     println(foo("Diego"))
     println(foo2("Diego"))
     println(foo3())     
     println( funcMonadic( () => print("A") ).andThen28( () => print(" -> B") ) )
     println("--------------")
     println( bigMonadicPipe )
  }  
}