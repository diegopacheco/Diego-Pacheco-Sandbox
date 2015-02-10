import sbt._
import Keys._
// imports standard command parsing functionality
import complete.DefaultParsers._

import Utils._

object CommandExample {
  def hello = Command.command("hello") { state =>
    println("Hi! Sbt Commands Kicks Ass")
    state
  }
  def ten = Command.command("ten") { state =>
    for(i <- (1 until 10)){
    	println(i)
    }
    state
  }
  def calc = Command.args("calc","<a><b>") { (state,args) =>
	
	if (args==null || args.size <= 1)
		println(" Calc need arguments. EX: calc $b $b ")
	else 
		println(" {" + args(0) + "} + {" + args(1) + "} = {" + Utils.calc(args(0).toInt,args(1).toInt) + "}")		

    state
  }
  def cmd_help = Command.command("cmd_help") { state =>
    println("Welcome to the console. Avaliable Commands: ")
    println(" > hello ")
    println(" > ten ")
    println(" > calc $b $b ")
    state
  }
}