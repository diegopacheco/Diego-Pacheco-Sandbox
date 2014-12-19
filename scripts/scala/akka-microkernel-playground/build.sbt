import NativePackagerKeys._

packageArchetype.akka_application

name := "akka-microkernel-playground"

mainClass in Compile := Some("com.github.diegopacheco.sandbox.scala.akka.microkernel.HelloKernel")

version := "1.0"

scalaVersion := "2.11.4"

scalaVersion in ThisBuild := "2.11.4"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.7"

libraryDependencies += "com.typesafe.akka" % "akka-kernel_2.11" % "2.3.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.2"

libraryDependencies += "com.typesafe.akka" % "akka-remote_2.11" % "2.3.7"

// recompiled to akka 2.3.7 and scala 2.11
libraryDependencies += "com.romix.akka" % "akka-protostuff-serialization" % "0.1-SNAPSHOT"