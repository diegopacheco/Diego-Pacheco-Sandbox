package com.github.diegopacheco.sandbox.kotlin.idiom

import java.io.File

fun main(args: Array<String>) {
	
	val files = File("").listFiles()
	println(files?.size)
	println(files?.size ?: "empty")
	
	
	
}