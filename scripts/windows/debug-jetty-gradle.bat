set GRADLE_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,address=9999,server=y,suspend=n
echo Using GRADLE_OPTS = %GRADLE_OPTS%
gradle jettyRun