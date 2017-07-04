package com.github.diegopacheco.sandbox.kotlin.oop

interface Foo {
	val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
	override var count: Int = 0
}

fun main(args: Array<String>) {
	
	val x = Bar1(1)
	println(x.count)
	
	val c = Bar2()
	println(c.count)
	
}


