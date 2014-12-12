package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.FromConfig
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor

object SimpleSmallestMailBoxRouterAppConfig extends App {
  
  // Config Version
  
   val system2 = ActorSystem("SimpleSmallestMailBoxRouterAS2")
   val actorRouter2:ActorRef =  
       system2.actorOf(FromConfig.props(Props[GenericActor]).withRouter(FromConfig()), name = "routerSmallestMailboxConfig")

    Try.it() { () =>
        actorRouter2 ! "hi"
        actorRouter2 ! "hi"
        actorRouter2 ! "hi"
    }
  
  
}