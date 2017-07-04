package com.github.diegopacheco.sandbox.kotlin.idiom

fun String.spaceToCamelCase() {
	println("This should be camel case but its not! ")
}

fun main(args: Array<String>) {
	"Convert this to camelcase".spaceToCamelCase()
}

