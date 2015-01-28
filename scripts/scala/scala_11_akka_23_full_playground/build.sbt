name := "Scala_211_Akka_23_Full_Playground"

version := "1.0"

scalaVersion := "2.11.5"

val akkaVersion = "2.3.9"

scalaVersion in ThisBuild := "2.11.5"

javaOptions in run += s"-Djava.library.path=D:/diego/github/diego.pacheco/Diego-Pacheco-Sandbox/scripts/scala/scala_11_akka_23_full_playground/src/main/lib/sigar-amd64-winnt.dll"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" % "akka-kernel_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" % "akka-testkit_2.11" % akkaVersion

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.3"

libraryDependencies += "com.typesafe.akka" % "akka-remote_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" % "akka-persistence-experimental_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % akkaVersion

libraryDependencies += "org.fusesource" % "sigar" % "1.6.4"

// recompiled to akka 2.3.7 and scala 2.11
libraryDependencies += "com.romix.akka" % "akka-protostuff-serialization" % "0.1-SNAPSHOT"

// recompiled to akka 2.3.7 and scala 2.11
libraryDependencies += "com.romix.akka" % "akka-quickser-serialization" % "0.1-SNAPSHOT"

// recompiled to akka 2.3.7 and scala 2.11
libraryDependencies += "com.github.romix.akka" %% "akka-kryo-serialization" % "0.3.2"

libraryDependencies += "com.esotericsoftware.kryo" % "kryo" % "2.24.0"

//libraryDependencies += "com.esotericsoftware.reflectasm" % "reflectasm" % "1.09"
