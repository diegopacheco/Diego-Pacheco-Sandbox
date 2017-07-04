package com.github.diegopacheco.sandbox.kotlin.oop

typealias Name = String

typealias Predicate<T> = (T) -> Boolean

fun main(args: Array<String>) {
	
	val n:Name = "Diego"
	println(n)
	println(n as String)
	println(n is String)
	
}