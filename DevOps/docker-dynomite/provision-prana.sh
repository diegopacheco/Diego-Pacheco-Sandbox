#!/bin/bash

cd /usr/local/
export GRADLE_USER_HOME=/usr/local/gradle_home

git clone https://github.com/Netflix/Prana.git

cd Prana
./gradlew build distZip -x test

cd build/distributions/
unzip Prana-0.1.0-SNAPSHOT.zip