package com.github.diegopacheco.sandbox.scala.apollo.topic

import org.fusesource.stompjms.StompJmsConnectionFactory
import org.fusesource.stompjms.StompJmsDestination;
import javax.jms.TextMessage
import javax.jms.Session
import scala.util.control.Breaks._

object Listener {
    def main(args: Array[String]) {
        val destination = "/topic/event"
        var factory = new StompJmsConnectionFactory()
        factory.setBrokerURI("tcp://localhost:61613")

        var connection = factory.createConnection("admin", "password")
        connection.start()
        
        var session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
        var dest = StompJmsDestination.createDestination(destination)

        var consumer = session.createConsumer(dest)
        var start = System.currentTimeMillis()
        var count = 0
        println("Waiting for messages...")
        
        breakable {
	        while(true) {
	            var msg = consumer.receive() match {
	            	 case x:TextMessage => 
	            	   	  var body = x.getText()
	            	   	  if("SHUTDOWN".equals(body)) {
	            	   		  var diff = System.currentTimeMillis() - start
	            	   		  println(format("Received %d in %.2f seconds", count, (1.0*diff/1000.0)))
	            	   		  break
	            	   	  } else {
	            	   		  if( count == 0 ) 
	            	   			  start = System.currentTimeMillis()	            	   		  
	            	   		  
	            	   		  count += 1
	            	   		  if( count % 1000 == 0 ) 
	            	   			  println(format("Received %d messages.", count))
	            	   		  
	            	   	 }
	                 case a:Any => 
	                     println("Unexpected message type " + a.getClass())
	          }
           }        
       }
       connection.close()
    }
}
