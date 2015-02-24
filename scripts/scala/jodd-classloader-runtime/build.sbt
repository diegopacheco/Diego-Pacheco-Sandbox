name := "jodd-classloader-runtime"

scalaVersion := "2.11.5"

version := "1.0"

scalaVersion in ThisBuild := "2.11.5"

resolvers += "Akka Repo" at "http://repo.akka.io/releases" 

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Repo" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.10",
  "org.jodd" % "jodd-core" % "3.6.4"
)

initialCommands in console :=
  """
    |
    |""".stripMargin
