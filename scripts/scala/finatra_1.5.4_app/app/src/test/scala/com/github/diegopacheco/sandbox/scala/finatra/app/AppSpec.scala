package ccom.github.diegopacheco.sandbox.scala.finatra.app.test

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import com.twitter.finatra.test._
import com.twitter.finatra.FinatraServer
import com.github.diegopacheco.sandbox.scala.finatra.app._

class AppSpec extends FlatSpecHelper {

  val app = new ExampleApp()
  override val server = new FinatraServer
  server.register(app)
}
