@ECHO off
set SCRIPT_DIR=%~dp0
java -XX:ReservedCodeCacheSize=1024M -XX:+CMSClassUnloadingEnabled -XX:+CMSClassUnloadingEnabled -Xmx1024M -Xss2M -jar "%SCRIPT_DIR%sbt-launch.jar" %*