package com.github.diegopacheco.sandbox.scala.twitter.finagle.fun

import com.twitter.finagle.{Httpx, Service}
import com.twitter.finagle.httpx
import com.twitter.util.{Await, Future}

object Client extends App {
  val client: Service[httpx.Request, httpx.Response] = Httpx.newService("www.scala-lang.org:80")
  val request = httpx.Request(httpx.Method.Get, "/")
  request.host = "www.scala-lang.org"
  val response: Future[httpx.Response] = client(request)
  response.onSuccess { resp: httpx.Response =>
    println("GET success: " + resp)
  }
  Await.ready(response)
}