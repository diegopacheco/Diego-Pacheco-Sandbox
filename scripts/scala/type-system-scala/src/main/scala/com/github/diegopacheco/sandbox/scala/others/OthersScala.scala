package com.github.diegopacheco.sandbox.scala.others

object OthersScala extends App {
  
     val x = 10
     var y = 3
     
     assert( x > 0 )
     assert( y > 0)
     println("x and y are bigger than ZERO!")
     
     require( x > y )
     println("X is bigger than Y")
     
     y = 11
     require( x > y )
     println("X is bigger than Y ? ")
     
}