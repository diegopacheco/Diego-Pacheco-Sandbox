package com.github.diegopacheco.sandbox.scala.destructuring.bindings

import java.sql.Time

object DestructionApp extends App {
  
    val tuple = ('a', 1)
    val (char, digit) = tuple
    
    case class Tweet(text:String,timestamp:Time)
    
    val tweet = Tweet("just tweeting", Time.valueOf("12:00:00"))
    val Tweet(text, timestamp) = tweet
  
    println(tuple)
    println(tweet)
    
}