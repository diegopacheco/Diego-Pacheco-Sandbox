package com.github.diegopacheco.sandbox.scala.jchan.fun

import fr.loof.jchan.Message
import fr.loof.jchan.inmem.Pipe
import fr.loof.jchan.Receiver

object SimpleJChanApp extends App {

  var p: Pipe = new Pipe()

  new Thread(new Runnable() {
		def run():Unit = {
		     var msg: Message = p.receive(0)
		     val m:Message = new Message("this is the response")
		     println("sending: " + m)
         msg.ret.send(m)	
		}
	}).start()
    
	val req:Message = new Message("this is the request")
  println(req)
  val ret: Receiver = p.send(req)
  val response: Message = ret.receive(Receiver.RET)
  println(response)
  assert("this is the response".equals(new String(response.data)))

}