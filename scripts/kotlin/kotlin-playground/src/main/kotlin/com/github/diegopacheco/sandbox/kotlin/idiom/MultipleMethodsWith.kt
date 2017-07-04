package com.github.diegopacheco.sandbox.kotlin.idiom

fun main(args: Array<String>) {

	class Turtle {
		fun penDown() = println("Down")
		fun penUp() = println("Up")
		fun turn(degrees: Double) = println("Turn ${degrees}")
		fun forward(pixels: Double) = println("Forward ${pixels}")
	}

	val myTurtle = Turtle()
	with(myTurtle) {
		penDown()
		for (i in 1..4) {
			forward(100.0)
			turn(90.0)
		}
		penUp()
	}

}