package com.github.diegopacheco.akkastreams.fun

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

object BasicsMain extends App {
    
    implicit val system = ActorSystem("basics")
    implicit val materializer = ActorMaterializer()
    import system.dispatcher
    
     Source( () => List("1","2","a","b","c").iterator ).
      map(_.toUpperCase).
      runForeach(println)

}