#!/bin/bash

wget -q http://repositories.sensuapp.org/apt/pubkey.gpg -O- | sudo apt-key add -
echo "deb     http://repositories.sensuapp.org/apt sensu main" | sudo tee /etc/apt/sources.list.d/sensu.list

sudo apt-get update
sudo apt-get install sensu

sudo wget -O /etc/sensu/conf.d/client.json http://sensuapp.org/docs/0.21/files/client.json
sudo chown -R sensu:sensu /etc/sensu

sudo sensu-install -p disk-checks:1.0.2
sudo mv /home/vagrant/sensu-client.json /etc/sensu/config.json
sudo mv /home/vagrant/client-config.json /etc/sensu/conf.d/client.json

sudo /etc/init.d/sensu-client start
sudo update-rc.d sensu-client defaults