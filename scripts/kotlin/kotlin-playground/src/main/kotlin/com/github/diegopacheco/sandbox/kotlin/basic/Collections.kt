package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	val items = listOf("Apple", "Orange", "Mango")
	for (item in items) {
		println(item)
	}

	when {
		"Orange" in items -> println("Orange are juicy")
		"Banana" in items -> println("Banana is fine too")
	}

}