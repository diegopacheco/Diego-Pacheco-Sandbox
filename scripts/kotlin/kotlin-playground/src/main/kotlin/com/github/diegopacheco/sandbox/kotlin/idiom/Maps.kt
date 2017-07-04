package com.github.diegopacheco.sandbox.kotlin.idiom

fun main(args: Array<String>) {

	val cities = mapOf("Brazil" to "Brazilia", "EUA" to "DC", "Spain" to "Madrid")

	println("Capitals... ")
	for ((k, v) in cities) {
		println("$k -> $v")
	}
	
	println(cities["Brazil"])

}