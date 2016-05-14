#!/bin/bash

#
# ES
#
sudo rpm --import http://packages.elastic.co/GPG-KEY-elasticsearch
sudo su -c 'echo "[elasticsearch-1.7]
name=Elasticsearch repository for 1.7.x packages
baseurl=http://packages.elastic.co/elasticsearch/1.7/centos
gpgcheck=1
gpgkey=http://packages.elastic.co/GPG-KEY-elasticsearch
enabled=1" >> /etc/yum.repos.d/elasticsearch.repo'

sudo yum install -y elasticsearch
sudo systemctl start elasticsearch
sudo systemctl enable elasticsearch

#
# Kibana
#
sudo su -c 'echo "[kibana-4.1]
name=Kibana repository for 4.1.x packages
baseurl=http://packages.elastic.co/kibana/4.1/centos
gpgcheck=1
gpgkey=http://packages.elastic.co/GPG-KEY-elasticsearch
enabled=1" >> /etc/yum.repos.d/kibana.repo'

sudo yum install -y kibana
sudo systemctl start kibana
sudo chkconfig kibana on

#
# Logstash
#
sudo su -c 'echo "[logstash-1.5]
name=logstash repository for 1.5.x packages
baseurl=http://packages.elasticsearch.org/logstash/1.5/centos
gpgcheck=1
gpgkey=http://packages.elasticsearch.org/GPG-KEY-elasticsearch
enabled=1" >> /etc/yum.repos.d/logstash.repo'

sudo yum install -y logstash
