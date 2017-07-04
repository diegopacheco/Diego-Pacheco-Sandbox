package com.github.diegopacheco.sandbox.kotlin.idiom

data class Customer(val name: String, val email: String)

fun main(args: Array<String>) {
	
	val c = Customer("Diego", "diego.pacheco.it@gmail.com")
	println(c)
	
}