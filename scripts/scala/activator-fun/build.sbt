name := "activator-fun"

version := "1.0"

scalaVersion := "2.10.4"

scalaVersion in ThisBuild := "2.10.4"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

resolvers += "fwbrasil" at "http://fwbrasil.net/maven"

resolvers += "repo1" at "http://repo1.maven.org/maven2"

libraryDependencies += "net.fwbrasil" %% "activate-core" % "1.6"