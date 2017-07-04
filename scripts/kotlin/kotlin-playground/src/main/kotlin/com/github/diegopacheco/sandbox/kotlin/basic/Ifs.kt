package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	fun maxOf(a: Int, b: Int): Int {
		if (a > b) {
			return a
		} else {
			return b
		}
	}
	
	fun minOf(a: Int, b: Int) = if (a < b) a else b

	println(maxOf(2,5))
	println(minOf(2,5))
	
}