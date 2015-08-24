package com.github.diegopacheco.sandbox.scala.twitter.finagle.fun

import com.twitter.finagle.{Httpx, Service}
import com.twitter.finagle.httpx.{Request, Response}
import com.twitter.util.Await

object Proxy extends App {
  val client: Service[Request, Response] =
    Httpx.newService("www.google.com:80")

  val server = Httpx.serve(":8080", client)
  Await.ready(server)
}