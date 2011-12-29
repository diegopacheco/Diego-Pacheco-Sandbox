package com.github.diegopacheco.sandbox.scripts.scala.colletions

object MapCollectionsFun extends App {
	
	val twitters = Map("@diego_pacheco" -> "Diego Pacheco",
	                   "@toff" -> "Christophe",
	                   "@alepoletto" -> "Poletto")
    
	val frenchKeys = twitters filterKeys(_ startsWith "@to")                     
    println(frenchKeys)
    
    val advancedFrenchKeys = twitters filter { element =>
        val (key,value) = element
        (key startsWith "@to") && (value contains "phe")
	} 
    println(advancedFrenchKeys)
    
}