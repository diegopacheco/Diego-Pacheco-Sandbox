package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	val items = listOf("apple", "banana", "kiwi")
	for (item in items) {
		println("Foreach ${item}")
	}

	for (index in items.indices) {
		println("for -> item at $index is ${items[index]}")
	}

	var index = 0
	while (index < items.size) {
		println("while -> item at $index is ${items[index]}")
		index++
	}

}