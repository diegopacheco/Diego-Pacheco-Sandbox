package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {
	
	fun factorialV1(n:Int):Int = if (n ==1) 1 else  n * factorialV1(n -1) 
	
	fun factorialV2(n:Int):Int = when(n){
		1 -> 1
		is Int -> n * factorialV2(n-1)
		else -> 0
	}
	
	println(factorialV1(6))
	println(factorialV2(6))
	
}
		