package com.github.diegopacheco.sandbox.scala.parser.combinators

import scala.util.parsing.combinator.RegexParsers

abstract class Expression {
  def evaluate(): Int
}

case class Number(value: Int) extends Expression {
  def evaluate() = value
}

case class Parens(expression: Expression) extends Expression {
  def evaluate() = expression.evaluate()
}

case class Addition(left: Expression, right: Expression) extends Expression {
  def evaluate() = left.evaluate() + right.evaluate()
}

case class Substraction(left: Expression, right: Expression) extends Expression {
  def evaluate() = left.evaluate() - right.evaluate()
}

object SimpleExpressionParser extends RegexParsers {
  def parse(s: String): Expression = {
    parseAll(expression, s) match {
      case Success(r, _) => r
      case NoSuccess(msg, _) => throw new Exception(msg)
    }
  }
  
  val operator = "+" | "-"
  
  val number = regex("""\d+""".r) ^^ {
    case v => Number(v.toInt)
  }
  
  val binary = (number | parens) ~ operator ~ expression ^^ {
    case l ~ "+" ~ r => Addition(l, r)
    case l ~ "-" ~ r => Substraction(l, r)
  }
  
  val expression: Parser[Expression] = binary | parens | number
  
  val parens = "(" ~ expression ~ ")" ^^ {
    case "(" ~ e ~ ")" => Parens(e)
  }
  
}

object SimpleParserApp extends App {

  import SimpleExpressionParser._
  
  println( SimpleExpressionParser.parse("1").evaluate() )
  println( SimpleExpressionParser.parse("1 + 2").evaluate() )
  println( SimpleExpressionParser.parse("1 + (2 + 3) + 4 + 5").evaluate() )

}