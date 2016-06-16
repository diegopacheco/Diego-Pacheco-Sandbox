#!/bin/bash

#
# Install Java 8 and Scala 2.11
#

#
# Install Java 8 
#
cd /usr/local/
sudo wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u91-b14/jdk-8u91-linux-x64.rpm"
sudo rpm -ivh jdk-8u91-linux-x64.rpm

#
# Install Scala 2.11
#
cd /usr/local/
sudo wget http://downloads.typesafe.com/scala/2.11.7/scala-2.11.7.tgz
sudo tar -xzvf scala-2.11.7.tgz
sudo rm -rf scala-2.11.7.tgz

sudo echo "alias cls='clear'" >> /home/vagrant/.bashrc

sudo echo "export SCALA_HOME=/usr/local/scala-2.11.7" >> /home/vagrant/.bashrc
sudo echo "export PATH=$PATH:/usr/local/scala-2.11.7/bin" >> /home/vagrant/.bashrc

