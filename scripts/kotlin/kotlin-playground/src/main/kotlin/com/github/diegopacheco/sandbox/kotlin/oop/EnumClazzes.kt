package com.github.diegopacheco.sandbox.kotlin.oop

enum class Direction {
	NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
	RED(0xFF0000),
	GREEN(0x00FF00),
	BLUE(0x0000FF)
}

fun main(args: Array<String>) {

	val e = Direction.NORTH
	println(e)
	
	val c = Color.BLUE
	println(c)

}