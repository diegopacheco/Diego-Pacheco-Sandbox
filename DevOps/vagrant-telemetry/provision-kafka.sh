#!/bin/bash

cd /usr/local/
sudo wget http://www.eu.apache.org/dist//kafka/0.8.2.0/kafka_2.10-0.8.2.0.tgz
tar -xzf kafka_2.10-0.8.2.0.tgz
rm -rf kafka_2.10-0.8.2.0.tgz
cd kafka_2.10-0.8.2.0
