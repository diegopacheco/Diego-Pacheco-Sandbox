package com.github.diegopacheco.sandbox.scala.functions

object ScalaFunctionsFun extends App {
	
	// MAP (reutrn a List) - List(2, 4, 6, 8, 10)
  
	println(  List(1,2,3,4,5).map ( (i:Int) => i * 2 )  )	
	println(  List(1,2,3,4,5).map ( _ * 2 ) )	
	println(  List(1,2,3,4,5) map (_ * 2 ) )
	
	// FOREACH (side effects only - no return) just print-it
  
	List(1,2,3,4,5).foreach ( (i:Int) => println(i * 2 ) )	
	List(1,2,3,4,5).foreach ( i => println(i * 2) )	
	List(1,2,3,4,5) foreach ( i => println(i * 2) )
	
	// FILTER - List(2, 4)
	
	println(  List(1,2,3,4,5).filter ( (i:Int) => i % 2 == 0 )  )	
	println(  List(1,2,3,4,5).filter ( _ % 2 == 0 ) )	
	println(  List(1,2,3,4,5) filter (_ % 2 == 0 ) )
	
	// ZIP - List((1,6), (2,7), (3,8))
	
	println(  List(1,2,3,4).zip( List(6,7,8) ))		
	
	// FOLD LEFT / RIGHT - 20
	
	println( List(2,3,4,5,6).foldLeft(0)((a:Int,i:Int) => a + i) )
	println( List(2,3,4,5,6).foldRight(0)((a:Int,i:Int) => a + i) )
	
	// FIND - Some(Pessoa(58,Nilseu))
	
	case class Pessoa(idade:Int,nome:String)
	println(  List(Pessoa(28,"Diego"),Pessoa(58,"Nilseu")).find( (p:Pessoa) => p.idade >= 55 ) )
	
	// DROP - List(5, 6)
	
	println( List(2,3,4,5,6).drop(3))
	println( List(2,3,4,5,6) drop 3 )
	    
	// DROPWHILE - List(3, 4, 5)
	
	println(  List(1,2,3,4,5).dropWhile ( (i:Int) => i < 3)  )
	
	// Flatten - List(1, 2, 3, 4)
	
	println( List(List(1, 2), List(3, 4)).flatten )
}		