@ECHO ON

CALL j6
CALL set-mrhome services

pushd D:\diego\svn-repos\wcsiLegra\cortellis\trunk\Services-SRC\management-routing\ngs-mr-parent
mvn clean install

