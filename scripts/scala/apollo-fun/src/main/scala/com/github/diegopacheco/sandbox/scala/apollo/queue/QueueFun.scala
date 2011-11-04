package com.github.diegopacheco.sandbox.scala.apollo.queue

import org.fusesource.stompjms.StompJmsConnectionFactory
import org.fusesource.stompjms.StompJmsDestination
import javax.jms.MessageProducer
import javax.jms.Connection
import javax.jms.Destination
import javax.jms.Session
import javax.jms.DeliveryMode
import javax.jms.TextMessage

object QueueFun {  
   def main(args: Array[String]) {
        var conn    = init
        var session = createSession(conn)
        var dest    = createDestination("/queue/test.queue")
        
        sendMsgToQueue("Test msg, Apollo & Scala Rocks", session, dest)
        
        createConsumer(session,dest).receive() match {
	        case x:TextMessage => println("Msg Received: " + x.getText())
	        case _ => println("Error I dont know this type!" )
        }        
        conn.close()        
   }  
   def init():Connection = {
        var factory = new StompJmsConnectionFactory()
        factory.setBrokerURI("tcp://localhost:61613")

        var connection = factory.createConnection("admin", "password")
        connection.start()
        connection 
   }   
   def createSession(conn:Connection):Session = {
       conn.createSession(false, Session.AUTO_ACKNOWLEDGE)
   }   
   def createConsumer(session:Session,dest:org.fusesource.stompjms.StompJmsDestination) = {
       session.createConsumer(dest)  
   }   
   def createDestination(name:String):org.fusesource.stompjms.StompJmsDestination = {
	   StompJmsDestination.createDestination(name)
   }  
   def sendMsgToQueue(body:String,session:Session,dest: org.fusesource.stompjms.StompJmsDestination): Unit = {    
	   var producer = session.createProducer(dest)
	   producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT)    
	   producer.send(session.createTextMessage(body))
  }   
}

