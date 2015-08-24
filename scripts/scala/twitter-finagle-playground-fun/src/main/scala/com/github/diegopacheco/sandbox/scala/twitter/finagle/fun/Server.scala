package com.github.diegopacheco.sandbox.scala.twitter.finagle.fun

import com.twitter.finagle.{Httpx, Service}
import com.twitter.finagle.httpx
import com.twitter.util.{Await, Future}

object Server extends App {
  val service = new Service[httpx.Request, httpx.Response] {
    def apply(req: httpx.Request): Future[httpx.Response] =
      Future.value(
        httpx.Response(req.version, httpx.Status.Ok)
      )
  }
  val server = Httpx.serve(":8080", service)
  Await.ready(server)
}