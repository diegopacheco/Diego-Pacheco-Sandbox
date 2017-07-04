package com.github.diegopacheco.sandbox.kotlin.oop

annotation class Special(val why: String)
@Special("example") class FooAnnotation {}

fun main(args: Array<String>) {
	
	val f = FooAnnotation()
	println(f.javaClass.annotations[0])
	
}