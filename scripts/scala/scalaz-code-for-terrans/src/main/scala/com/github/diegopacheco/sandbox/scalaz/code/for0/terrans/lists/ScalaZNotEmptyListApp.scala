package com.github.diegopacheco.sandbox.scalaz.code.for0.terrans.lists

import scalaz._
import Scalaz._

//
// NonEmptyList: a data type for representing one or more elements of the same type that guarantees successful 
// termination of head, tail and other operations
//
object ScalaZNotEmptyListApp extends App {
	
	val nel = NonEmptyList(2,0)
	println( nel )
	
	val nel2 = nel.reverse
	println( nel2 )
	
	var zpr = nel.toZipper
	println( zpr )
	
}