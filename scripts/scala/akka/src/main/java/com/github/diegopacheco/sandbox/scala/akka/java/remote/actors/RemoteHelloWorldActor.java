package com.github.diegopacheco.sandbox.scala.akka.java.remote.actors;

import akka.actor.UntypedActor;

public class RemoteHelloWorldActor extends UntypedActor {
	public void onReceive(Object msg) {
		getContext().tryReply(msg + " World");
	}
}
