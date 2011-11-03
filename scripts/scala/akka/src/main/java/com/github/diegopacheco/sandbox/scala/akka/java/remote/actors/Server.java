package com.github.diegopacheco.sandbox.scala.akka.java.remote.actors;

import static akka.actor.Actors.*;

public class Server {
	public static void main(String[] args){
		remote().start("localhost", 2552).register(
				  "hello-service",
				   actorOf(RemoteHelloWorldActor.class));
	}
}
