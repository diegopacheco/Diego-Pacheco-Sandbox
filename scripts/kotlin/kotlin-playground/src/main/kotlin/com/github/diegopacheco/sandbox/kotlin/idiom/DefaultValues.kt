package com.github.diegopacheco.sandbox.kotlin.idiom

fun printMe(a:Int = 0, b: String = "") {
	println("A = ${a}, B = ${b}")
}

fun main(args: Array<String>) {
	
	printMe()
	printMe(a = 10)
	printMe(b = "Works", a = 2)
	
}