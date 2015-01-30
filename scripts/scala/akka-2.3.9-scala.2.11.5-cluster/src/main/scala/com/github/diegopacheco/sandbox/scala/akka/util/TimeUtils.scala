package com.github.diegopacheco.sandbox.scala.akka.util

import scala.concurrent.duration._

object TimeUtils {

  def wait(seconds:Int): Unit ={
     Thread.sleep(seconds.seconds.toMillis)
  }

}
