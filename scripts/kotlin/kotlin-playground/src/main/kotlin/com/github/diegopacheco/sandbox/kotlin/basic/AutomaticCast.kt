package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	fun getStringLength(obj: Any): Int? {
		if (obj is String) {
			return obj.length
		}
		return null
	}
	
	println(getStringLength(1))
	println(getStringLength("ABC"))

}
