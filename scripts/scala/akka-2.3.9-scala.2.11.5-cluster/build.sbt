import com.typesafe.sbt.SbtMultiJvm
import com.typesafe.sbt.SbtMultiJvm.MultiJvmKeys.MultiJvm

name := "akka-2.3.9-scala.2.11.5-cluster"

version := "1.0"

scalaVersion := "2.11.5"

val akkaVersion = "2.3.9"

scalaVersion in ThisBuild := "2.11.5"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-kernel" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % akkaVersion

libraryDependencies +=  "com.typesafe.akka" %% "akka-contrib" % akkaVersion

libraryDependencies += "org.fusesource" % "sigar" % "1.6.4"

libraryDependencies +=  "io.kamon" % "sigar-loader" % "1.6.5-rev001"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.3"
