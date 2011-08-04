package com.github.diegopacheco.sandbox.scripts.scala.actors

case object Hop
case object Stop

case class Bunny(id: Int) extends scala.actors.Actor {
    
    this ! Hop    // Constructor code
    start()       // ditto
    
    def act() {
        loop {
            react {
                case Hop =>
                    println(this + " ")
                    this ! Hop
                    Thread.sleep(500)
                case Stop =>
                    println("Stopping " + this)
                    exit()
            }
        }
    }
    
}

object ActorsMain {
    def main(args: Array[String]): Unit = {

        val bunnies = Range(0, 3).map(new Bunny(_))
        println("Press RETURN to quit")
        readLine
        bunnies.foreach(_ ! Stop)
        
    }
}

