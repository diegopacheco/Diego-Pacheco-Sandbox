package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

object forfun {
  def main(args : Array[String]) = {

	val names = Array("Ted Neward", "Neal Ford", "Scott Davis","Venkat Subramaniam", "David Geary")

    for {
      name <- names
      firstName = name.substring(0, name.indexOf(' '))
    } System.out.println("Found " + firstName)
    
  }
}