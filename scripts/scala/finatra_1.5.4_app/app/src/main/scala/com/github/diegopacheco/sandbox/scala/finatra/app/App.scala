package com.github.diegopacheco.sandbox.scala.finatra.app

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

class ExampleApp extends Controller {
     get("/"){ request => 
         render.plain("hello").toFuture
     }
}

object App extends FinatraServer {
  register(new ExampleApp())
}
