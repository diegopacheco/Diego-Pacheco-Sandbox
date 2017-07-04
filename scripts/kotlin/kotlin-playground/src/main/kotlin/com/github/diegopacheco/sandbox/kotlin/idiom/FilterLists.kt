package com.github.diegopacheco.sandbox.kotlin.idiom

fun main(args: Array<String>) {
	
	val numbers = listOf(1,2,3,4,5,6,7,8,9)
	
	val evens = numbers.filter { x -> x.mod(2) == 0 }
	
	val odds = numbers.filter { it.mod(2) != 0 }
	
	println("Numbers are ${numbers}")
	println("Evens are ${evens}")
	println("Odds are ${odds}")
	
}