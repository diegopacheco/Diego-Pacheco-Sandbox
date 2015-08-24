package com.github.diegopacheco.akkastreams.fun

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Sink
import java.util.Date

final case class Author(handle:String)
final case class Hashtag(name:String)
final case class Tweet(author:Author, timestamp:Long, body:String) {
  def hashtags:Set[Hashtag] =
    body.split(" ").collect { case t if t.startsWith("#") => Hashtag(t) }.toSet
}
 
object TweeterMain extends App {
  
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()
  
  val akka   = Hashtag("#akka")
  val tweets = Source( () => List( Tweet(Author("Diego"),new Date().getTime,"#akka kicks ass"),
                                   Tweet(Author("Diego Pacheco"),new Date().getTime,"#akka kicks ass"),
                                   Tweet(Author("JohnOld"),new Date().getTime,"#Java kicks ass")
                      ).iterator )
 
  val authors: Source[Author, Unit] =
    tweets
      .filter(_.hashtags.contains(akka))
      .map(_.author)
 
   authors.runForeach(println)
   
  
}