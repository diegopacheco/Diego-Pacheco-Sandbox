set SCRIPT_DIR=%~dp0
java -Xmx512M -jar "%SCRIPT_DIR%sbt-launch.jar" %*
REM java -Xmx512m -jar `dirname $0`/sbt-launch.jar "$@"