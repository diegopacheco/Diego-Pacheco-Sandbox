#!/bin/bash

cd /usr/local/

export GRADLE_USER_HOME=/usr/local/gradle_home

git clone https://github.com/Netflix/Prana.git

Prana/gradlew build distZip

cd /usr/local/Prana/build/distributions/
unzip Prana-0.1.0-SNAPSHOT.zip