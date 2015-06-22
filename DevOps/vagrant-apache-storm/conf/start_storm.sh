#!/bin/bash
 
sudo /opt/zookeeper-3.4.6/bin/zkServer.sh start &
sleep 10
sudo /opt/apache-storm-0.9.5/bin/storm nimbus &
sleep 30
sudo /opt/apache-storm-0.9.5/bin/storm ui &
sleep 30
sudo /opt/apache-storm-0.9.5/bin/storm supervisor &