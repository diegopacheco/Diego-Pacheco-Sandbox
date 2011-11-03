package com.github.diegopacheco.sandbox.scala.akka.fsm

import akka.actor.{ Actor, FSM }
import akka.event.EventHandler
import akka.util.duration._
import akka.actor.FSM._

sealed trait ExampleState
case object A extends ExampleState
case object B extends ExampleState
case object C extends ExampleState
case object Move

class ABC extends Actor with FSM[ExampleState, Unit] {

  import FSM._

  startWith(A, Unit, 20 seconds)

  when(A) {
    case Ev(Move) =>
      EventHandler.info(this, "Go to B and move on after 5 seconds")
      goto(B) forMax (5 seconds)
  }

  when(B) {
    case Ev(StateTimeout) =>
      EventHandler.info(this, "Moving to C")
      goto(C)
  }

  when(C) {
    case Ev(Move) =>
      EventHandler.info(this, "Stopping")
      stop
  }

  initialize // this checks validity of the initial state and sets up timeout if needed

}

object FsmFun {
  def main(args: Array[String]) {
    val a = Actor.actorOf[ABC]
    a.start()
    a !! Move
  }
}
