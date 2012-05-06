package com.github.diegopacheco.sandbox.scalaz.code.for0.terrans.lists

import scalaz._
import Scalaz._

object ScalaZList extends App {
	
	def p(f:Any):Unit = { println( f )  }
  
	// This interleave the 2 sequences making a new one based on one left all right on and on...
	//
    // Result: List((1,40), (1,50), (1,60), (2,40), (2,50), (2,60), (3,40), (3,50), (3,60))
	//
	p( (List(1, 2, 3) <|*|> List(40, 50, 60))  )
	
	// Take each element on the left and mutiply by each element on the right
	//
    // Result: List(30, 60, 50, 100)
	//
	p( List(3,5).<**>(List(10, 20))(_ * _) )
	
	//
	// *> and <* Repeat N times(N = number of elemets) the content of other list.
	//
	// Result: List(10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30)
	//         List(B, B, B)
	//
	//
	p( (List("A","B","C","D") *> List(10, 20, 30)) )
	p( (List("B") <* List(10, 20, 30)) )
	
	
	val a, b, c, d = List(1)
	
	//
	// Result: List(4)
	//
	p( a |@| b |@| c |@| d apply {_ + _ + _ + _} )
	
	//
	// Result: List(2)
	//
    p( (a |@| b){_ + _} )
    
    //
    // Monads like haskell
    //
    
    def s[A](a: A) = a.success[List[String]]
	def f[A](s: String) = ff(List(s))
    def ff[A](s: List[String]) = s.fail[Int]
	
	p(  s(7) *> s(8)   ) 
	p(  s(7) *> f("bzzt")  )
	
	//
	// using the pure trait to create aplicate functors
	// 
	//
	
	p( 1.pure[List]  )
	p( 1.pure[Tuple1]  )
	
	//
	//  |+| mapped operator
	//
	
	p( "abc" |+| "def"  )
	p( List(1,2,3) |+| List(4,5,6) )
	
	//
	// dual
	//
	
	// defabc
	p(  "abc".dual |+| "def".dual )
	
	// List(4, 5, 6, 1, 2, 3)
	p(  List(1,2,3).dual |+| List(4,5,6).dual )
	
	
	//
	// Equality
	//
	
	// true
	p(  "abc" === "abc" )
	
	// false
	p( List[Int](1,2,3) === List[Int](1,2,4) )
	
	//
	// null check
	//
	
	// default
	p( (null: String) ?? "default" )
	
	// abc
	p( "abc" ?? "default" )
	
	
	//
	// Ordering
	//
	
	p( 9 ?|? 8  ) // GT
	p( 9 ?|? 9  ) // EQ
	p( 9 ?|? 10 ) // LT
	
	//
	// max , min
	//
	
	p( 9 min 5 ) // 5
	p( 9 max 5 ) // 9 
	
	
	//
	// shows
	//
	
	p( List(1,2,3).shows ) // [1,2,3]
	p( "abc".show )        // List(a, b, c)
	p( List(1,2,3).show )  // List([, 1, ,, 2, ,, 3, ])
	
	
	
}