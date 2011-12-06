#!/bin/sh

BASE=`dirname $0`
LIB_DIR="$BASE/lib"
DIST_DIR="$BASE/dist"
CP=".:$DIST_DIR/jatran.jar"

for i in `ls $LIB_DIR/*.jar`;
do
	CP="$CP:$i"
done

java -cp $CP jatran.main.Main "$@" --input code-gen/in --output code-gen/out/
