package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	fun maxOf(a: Int, b: Int): Int {
		if (a > b) {
			return a
		} else {
			return b
		}
	}

	println(maxOf(2,5))
	
}