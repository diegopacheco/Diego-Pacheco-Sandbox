import sbt._
import Keys._

object SbtIdeaBuild extends Build with BuildExtra {
  lazy val sbtIdea = Project("sbt-idea", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ ScriptedPlugin.scriptedSettings ++ Seq(
    sbtPlugin := true,
    organization := "com.github.mpeltonen",
    name := "sbt-idea",
    version := "1.7.0-SNAPSHOT",
    sbtVersion in Global := "0.13.2",
    scalaVersion in Global := "2.11.0",
    publishTo <<= version { (v: String) =>
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := (_ => false),
    pomExtra := extraPom,
    resolvers ++= Seq(
      Classpaths.typesafeSnapshots,
      Resolver.url("scalasbt snapshots", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns)
    ),
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
    libraryDependencies ++= Seq(
      "commons-io" % "commons-io" % "2.4",
      "junit" % "junit" % "4.11",
      "com.novocode" % "junit-interface" % "0.8" % "test->default",
      "org.scalatest" %% "scalatest" % "1.9.1" % "test"
    )
  ) ++ addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")


  def extraPom = (
    <developers>
      <developer>
      <id>diegopacheco</id>
      <name>Diego Pacheco</name>
      <url>http://github.com/diegopacheco</url>
    </developer>
  </developers>)
}