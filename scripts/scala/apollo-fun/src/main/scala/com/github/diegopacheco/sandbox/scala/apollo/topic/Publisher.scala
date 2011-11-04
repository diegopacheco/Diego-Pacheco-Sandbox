package com.github.diegopacheco.sandbox.scala.apollo.topic

import org.fusesource.stompjms.StompJmsConnectionFactory
import org.fusesource.stompjms.StompJmsDestination
import javax.jms.MessageProducer
import javax.jms.Connection
import javax.jms.Destination
import javax.jms.Session
import javax.jms.DeliveryMode

object Publisher {

    def main(args: Array[String]) {
        var messages    = 10000
        var size        = 256
        var destination = "/topic/event"
        var body        = ""
        var DATA        = "abcdefghijklmnopqrstuvwxyz"        
        
        var i           = 0        
        while( i < size) {
            body += DATA.charAt(i%DATA.length())
            i += 1
        }

        var factory = new StompJmsConnectionFactory()
        factory.setBrokerURI("tcp://localhost:61613")

        var connection = factory.createConnection("admin", "password")
        connection.start()
        
        var session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
        var dest    = StompJmsDestination.createDestination(destination)
        
        var producer = session.createProducer(dest)
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT)

        i = 0
        while( i <= messages) {
            producer.send(session.createTextMessage(body))
            if( (i % 1000) == 0) {
                System.out.println(format("Sent %d messages", i))
            }
            i += 1
        }

        producer.send(session.createTextMessage("SHUTDOWN"))
        connection.close()

    }
}

