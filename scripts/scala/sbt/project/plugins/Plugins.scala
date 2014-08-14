import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val repo = "GH-pages repo" at "https://github.com/mpeltonen/sbt-idea"
  val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "1.6.0"
}