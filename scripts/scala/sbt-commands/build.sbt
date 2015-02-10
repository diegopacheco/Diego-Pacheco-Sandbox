import CommandExample._

name := "SBT Commands"

version := "1.0"

scalaVersion := "2.11.5"

organization := "Diego Pacheco"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10.4"

lazy val commonSettings = Seq(scalaVersion := "2.11.5")

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(commands ++= Seq(hello, ten, calc, cmd_help))