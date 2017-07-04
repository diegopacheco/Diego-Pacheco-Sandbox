package com.github.diegopacheco.sandbox.kotlin.basic

class Function {
	fun sum(a: Int, b: Int): Int {
		return a + b
	}
}

fun main(args: Array<String>) {
	println(Function().sum(1,2))
}