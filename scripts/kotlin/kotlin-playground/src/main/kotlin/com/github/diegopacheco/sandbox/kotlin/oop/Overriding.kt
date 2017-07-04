package com.github.diegopacheco.sandbox.kotlin.oop

fun main(args: Array<String>) {

	open class Base {
		open fun v() {
			println("BASE V!")
		}
	}

	class Derived() : Base() {
		override fun v() {
			println("DERIVED V!")
		}
		fun original() {
			super.v()
		}
	}
	
	val c = Derived()
	c.v()
	c.original()

}