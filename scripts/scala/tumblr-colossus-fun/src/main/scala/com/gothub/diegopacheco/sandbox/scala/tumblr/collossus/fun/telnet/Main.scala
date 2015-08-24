package com.gothub.diegopacheco.sandbox.scala.tumblr.collossus.fun.telnet

import colossus._
import service._
import protocols.telnet._

object Main extends App {

  implicit val io = IOSystem()

  Service.serve[Telnet]("hello-world" , 10010) { context => 
    context.handle{ connection => 
      connection.become {
        case TelnetCommand("say" :: text :: Nil) => {
          Callback.successful(TelnetReply(text))
        }
        case TelnetCommand("exit" :: Nil) => {
          connection.gracefulDisconnect()
          Callback.successful(TelnetReply("Bye!"))
        }
        case other => {
          Callback.failed(new IllegalArgumentException(s"Invalid command $other"))
        }
      }
    }
  }

}