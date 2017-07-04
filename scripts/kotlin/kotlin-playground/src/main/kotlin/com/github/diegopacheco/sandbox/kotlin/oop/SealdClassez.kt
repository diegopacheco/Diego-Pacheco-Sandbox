package com.github.diegopacheco.sandbox.kotlin.oop

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun main(args: Array<String>) {

	val x = NotANumber
	println(x)

	val y = Sum(Const(1.0), Const(1.0))
	println(y)

	fun eval(expr: Expr): Double = when (expr) {
		is Const -> expr.number
		is Sum -> eval(expr.e1) + eval(expr.e2)
		NotANumber -> Double.NaN
	}
	
	println(eval(x))
	println(eval(y))
	println(eval(Const(2.0)))

}