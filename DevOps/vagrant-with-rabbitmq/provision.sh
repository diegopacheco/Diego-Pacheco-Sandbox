#!/bin/bash

sudo apt-get update     
sudo apt-get install -y wget
sudo apt-get install -y curl
sudo apt-get install -y vim
sudo apt-get install -y git    
sudo apt-get install -y build-essential
sudo wget https://www.rabbitmq.com/rabbitmq-signing-key-public.asc
sudo apt-key add rabbitmq-signing-key-public.asc
sudo apt-get install -y rabbitmq-server