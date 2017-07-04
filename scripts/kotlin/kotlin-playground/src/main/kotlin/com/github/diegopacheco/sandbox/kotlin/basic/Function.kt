package com.github.diegopacheco.sandbox.kotlin.basic

class Function {

	fun sum(a: Int, b: Int): Int {
		return a + b
	}

	fun sub(a: Int, b: Int) = a - b

	fun printSum(a: Int, b: Int): Unit {
		println("sum of $a and $b is ${a + b}")
	}

	fun printSub(a: Int, b: Int) {
		println("Sub of $a and $b is ${a - b}")
	}

}

fun main(args: Array<String>) {
	println(Function().sum(1, 2))
	println(Function().sub(3, 2))
	Function().printSum(2, 2)
	Function().printSub(2, 2)
}