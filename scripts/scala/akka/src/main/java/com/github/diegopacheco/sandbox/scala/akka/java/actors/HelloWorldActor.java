package com.github.diegopacheco.sandbox.scala.akka.java.actors;

import akka.actor.UntypedActor;

class HelloWorldActor extends UntypedActor {
	public void onReceive(Object msg) {
		getContext().tryReply(msg + " World");
	}
}