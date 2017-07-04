package com.github.diegopacheco.sandbox.kotlin.idiom

fun main(args: Array<String>) {

	fun test() : Int {
		val result:Int = try {
			throw RuntimeException("error by design")
		} catch (e:Exception) {
			println(e)
			-1
		} 
		return result
	}
	
	println(test())

}