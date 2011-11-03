name := "AKKA Test"
version := "1.0"
scalaVersion := "2.9.0.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "se.scalablesolutions.akka" % "akka-actor" % "1.2"
libraryDependencies += "se.scalablesolutions.akka" % "akka-typed-actor" % "1.2"
libraryDependencies += "se.scalablesolutions.akka" % "akka-kernel" % "1.2"
libraryDependencies += "se.scalablesolutions.akka" % "akka-scalaz" % "1.2"
libraryDependencies += "se.scalablesolutions.akka" % "akka-remote" % "1.2"

