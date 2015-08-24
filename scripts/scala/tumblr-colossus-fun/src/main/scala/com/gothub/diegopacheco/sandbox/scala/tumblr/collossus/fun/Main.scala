package com.gothub.diegopacheco.sandbox.scala.tumblr.collossus.fun

import colossus._
import service._
import protocols.http._
import UrlParsing._
import HttpMethod._

object Main extends App {
  
  implicit val io_system = IOSystem()

  Service.become[Http]("http-echo", 9000){
    case request @ Get on Root => Callback.successful(request.ok("Hello world!"))
    case request @ Get on Root / "echo" / str => Callback.successful(request.ok(str))
  }
}