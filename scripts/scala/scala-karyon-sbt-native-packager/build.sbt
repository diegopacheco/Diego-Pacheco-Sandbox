name := "scala-karyon-sbt-native-packager"

version := "1.0"

scalaVersion := "2.11.7"

scalaVersion in ThisBuild := "2.11.7"

import NativePackagerKeys._

enablePlugins(JavaAppPackaging)

resolvers += DefaultMavenRepository 
resolvers += JavaNet1Repository
resolvers += "OSSSonatype" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.12"
libraryDependencies += "org.slf4j" % "slf4j-jdk14" % "1.7.12"
libraryDependencies += "com.sun.jersey" % "jersey-client" % "1.18.4"

libraryDependencies += "com.netflix.karyon" % "karyon2-core" % "2.7.0"
libraryDependencies += "com.netflix.karyon" % "karyon2-jersey-blocking" % "2.7.0"
libraryDependencies += "com.netflix.karyon" % "karyon2-archaius" % "2.7.0"

libraryDependencies += "com.netflix.karyon" % "karyon2-servo" % "2.7.0"
libraryDependencies += "com.netflix.karyon" % "karyon2-admin-web" % "2.7.0"
libraryDependencies += "com.netflix.karyon" % "karyon2-eureka" % "2.7.0"
