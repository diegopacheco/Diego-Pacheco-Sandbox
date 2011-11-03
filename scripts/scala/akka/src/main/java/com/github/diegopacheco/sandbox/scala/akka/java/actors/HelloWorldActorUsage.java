package com.github.diegopacheco.sandbox.scala.akka.java.actors;

import akka.actor.ActorRef;
import akka.actor.Actors;

public class HelloWorldActorUsage {
	public static void main(String[] args){
		ActorRef myActor = Actors.actorOf(HelloWorldActor.class);
		myActor.start();		
		Object res = myActor.ask("Hello").get();
		System.out.println(res);
	}
}
