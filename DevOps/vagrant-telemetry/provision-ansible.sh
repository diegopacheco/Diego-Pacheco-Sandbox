#!/bin/bash

#
# Install Ansible
#
cd /usr/local/src
sudo yum -y install git python-jinja2 python-paramiko PyYAML make MySQL-python
sudo git clone https://github.com/ansible/ansible.git
cd /usr/local/src/ansible
sudo git submodule update --init --recursive
sudo make install
sudo echo "[localhost]" > ~/ansible_hosts
sudo echo "localhost ansible_connection=local" >> ~/ansible_hosts
export ANSIBLE_INVENTORY=~/ansible_hosts
