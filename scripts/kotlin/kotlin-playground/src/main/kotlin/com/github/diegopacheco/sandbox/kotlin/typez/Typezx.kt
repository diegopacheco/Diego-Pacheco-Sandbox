package com.github.diegopacheco.sandbox.kotlin.typez

fun main(args: Array<String>) {
	
	val oneMillion = 1_000_000
	println(oneMillion)
	
	val creditCardNumber = 1234_5678_9012_3456L
	println(creditCardNumber)
	
	val b: Byte = 1
	println(b)
	
	val x: IntArray = intArrayOf(1, 2, 3)
	x[0] = x[1] + x[2]
	println(x)
	for(i in 0..2){
		println(x[i])
	}
	
}