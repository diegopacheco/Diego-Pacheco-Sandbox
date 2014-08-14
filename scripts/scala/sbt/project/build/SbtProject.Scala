import sbt._

class SbtProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val derby = "junit" % "junit" % "4.5"
  val scalatest = "org.scalatest" % "scalatest" % "1.2"
}