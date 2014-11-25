name := "Scala_211_Akka_23_Full_Playground"

version := "1.0"

scalaVersion := "2.11.4"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.6"

libraryDependencies += "com.typesafe.akka" % "akka-cluster_2.11" % "2.3.6"

libraryDependencies += "com.typesafe.akka" % "akka-kernel_2.11" % "2.3.6"