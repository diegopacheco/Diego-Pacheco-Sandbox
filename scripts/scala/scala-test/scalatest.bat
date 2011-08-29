set SCALATEST=%SCALA_HOME%\lib\scalatest-1.6.1.jar
scala -cp "%SCALATEST%" org.scalatest.tools.Runner -p . -o -s %1