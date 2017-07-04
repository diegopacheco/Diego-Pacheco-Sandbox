package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	fun describe(obj: Any): String =
			when (obj) {
				1 -> "One"
				"Hello" -> "Greeting"
				is Long -> "Long"
				!is String -> "Not a string"
				else -> "Unknown"
		    }

	println(describe(1))
	println(describe("Hello"))
	println(describe(1.0))
	println(describe(String))

}