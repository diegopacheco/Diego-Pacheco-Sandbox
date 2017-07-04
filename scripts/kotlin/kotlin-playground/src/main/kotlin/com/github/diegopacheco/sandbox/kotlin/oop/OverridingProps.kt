package com.github.diegopacheco.sandbox.kotlin.oop

fun main(args: Array<String>) {

	open class Foo {
		open val x:Int = 10
	}

	class Bar1:Foo() {
		override val x: Int = 11
	}
	
	val foo = Bar1()
	println(foo.x)

}