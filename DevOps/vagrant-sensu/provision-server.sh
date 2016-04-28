#!/bin/bash

# Messaging with Rabbitmq
sudo wget http://packages.erlang-solutions.com/erlang-solutions_1.0_all.deb
sudo dpkg -i erlang-solutions_1.0_all.deb

sudo apt-get update
sudo apt-get -y install erlang-nox=1:18.2

wget http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.0/rabbitmq-server_3.6.0-1_all.deb
sudo dpkg -i rabbitmq-server_3.6.0-1_all.deb

sudo /etc/init.d/rabbitmq-server start
sudo rabbitmqctl add_vhost /sensu
sudo rabbitmqctl add_user sensu secret
sudo rabbitmqctl set_permissions -p /sensu sensu ".*" ".*" ".*"

# Metric Store Redis
sudo apt-get -y install redis-server
sudo update-rc.d redis-server defaults
sudo /etc/init.d/redis-server restart

# Sensu
wget -q http://repositories.sensuapp.org/apt/pubkey.gpg -O- | sudo apt-key add -
echo "deb     http://repositories.sensuapp.org/apt sensu main" | sudo tee /etc/apt/sources.list.d/sensu.list

sudo apt-get update
sudo apt-get install sensu -y
sudo wget -O /etc/sensu/config.json http://sensuapp.org/docs/0.21/files/config.json
sudo wget -O /etc/sensu/conf.d/check_disk.json http://sensuapp.org/docs/0.21/files/check_disk.json
sudo wget -O /etc/sensu/conf.d/default_handler.json http://sensuapp.org/docs/0.21/files/default_handler.json

sudo chown -R sensu:sensu /etc/sensu
sudo /etc/init.d/sensu-server start
sudo /etc/init.d/sensu-api start
sudo update-rc.d sensu-server defaults
sudo update-rc.d sensu-api defaults

# Sensu Client
sudo wget -O /etc/sensu/conf.d/client.json http://sensuapp.org/docs/0.21/files/client.json
sudo chown -R sensu:sensu /etc/sensu
sudo sensu-install -p disk-checks:1.0.2
sudo /etc/init.d/sensu-client start
sudo update-rc.d sensu-client defaults

# Uchiwa - Dashboard
sudo apt-get install uchiwa -y
sudo mv /home/vagrant/uchiwa-config.json /etc/sensu/uchiwa.json
sudo /etc/init.d/uchiwa start
