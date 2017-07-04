package com.github.diegopacheco.sandbox.kotlin.oop

fun main(args: Array<String>) {

	fun isOdd(x: Int) = x.mod(2) != 0

	val numbers = listOf(1, 2, 3)
	println(numbers.filter(::isOdd))
	
	
}