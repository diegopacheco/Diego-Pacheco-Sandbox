package com.github.diegopacheco.sandbox.scala.camel.beans

class Middle {
	
    def process(msg:String):String = {
        println("canta?")
        "canta? " + msg
    }
    
}