package com.github.diegopacheco.sandbox.scala.akka.java.remote.actors;

import akka.actor.ActorRef;
import static akka.actor.Actors.*;

public class Client {
	public static void main(String[] args){
		ActorRef actor = remote().actorFor("hello-service", "localhost", 2552);
		Object res = actor.ask("Hello").get();
		System.out.println(res);
	}
}
