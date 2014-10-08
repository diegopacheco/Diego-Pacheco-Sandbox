package com.github.diegopacheco.sandbox.scala.disruptor.fun

import com.lmax.disruptor.EventFactory
import com.lmax.disruptor.EventHandler
import com.lmax.disruptor.RingBuffer
import java.nio.ByteBuffer
import scala.beans.BeanProperty
import com.lmax.disruptor.EventTranslatorOneArg
import com.lmax.disruptor.dsl.Disruptor
import java.util.concurrent.Executor
import java.util.concurrent.Executors

case class LongEvent(@BeanProperty var value:Long = 0)

class LongEventFactory extends EventFactory[LongEvent]{
  override def newInstance():LongEvent = LongEvent() 
}

class LongEventHandler extends EventHandler[LongEvent] {
   override def onEvent(event:LongEvent, sequence:Long, endOfBatch:Boolean):Unit = println("Event: " + event) 
}

class LongEventProducer(var ringBuffer:RingBuffer[LongEvent]){
    def onData(bb:ByteBuffer):Unit = {
        var sequence:Long  = ringBuffer.next()
        try{
            var event:LongEvent = ringBuffer.get(sequence)
            event.setValue(bb.getLong(0))
        }finally{
            ringBuffer.publish(sequence)
        }
    }
}

class LongEventProducerWithTranslator(var ringBuffer:RingBuffer[LongEvent]){
    val TRANSLATOR:EventTranslatorOneArg[LongEvent, ByteBuffer] = new EventTranslatorOneArg[LongEvent, ByteBuffer]() {
        def translateTo(event:LongEvent, sequence:Long, bb:ByteBuffer):Unit = event.setValue(bb.getLong(0)) 
    }

    def onData(bb:ByteBuffer):Unit = ringBuffer.publishEvent(TRANSLATOR, bb) 
}

object DisruptorApp extends App {
  
        // Executor that will be used to construct new threads for consumers
        val executor:Executor = Executors.newCachedThreadPool()

        // The factory for the event
        val factory:LongEventFactory  = new LongEventFactory()

        // Specify the size of the ring buffer, must be power of 2.
        val bufferSize:Int  = 1024

        // Construct the Disruptor
        val disruptor:Disruptor[LongEvent] = new Disruptor[LongEvent](factory, bufferSize, executor)

        // Connect the handler
        disruptor.handleEventsWith(new LongEventHandler())

        // Start the Disruptor, starts all threads running
        disruptor.start()

        // Get the ring buffer from the Disruptor to be used for publishing.
        val ringBuffer:RingBuffer[LongEvent] = disruptor.getRingBuffer()

        val producer:LongEventProducer = new LongEventProducer(ringBuffer)

        val bb:ByteBuffer = ByteBuffer.allocate(8)
        var l:Long = 0
        while(true){
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(1000);
            l = l + 1
        }
}