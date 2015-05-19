#!/bin/bash
set -e

# clear the MSYS MOTD
clear

cd "$(dirname "$BASH_SOURCE")"

ISO="D:/diego/bin/Boot2Docker/boot2docker.iso"
if [ ! -e "$ISO" ]; then
	echo 'copying initial boot2docker.iso (run "boot2docker.exe download" to update)'
	mkdir -p "$(dirname "$ISO")"
	cp ./boot2docker.iso "$ISO"
fi

echo 'initializing...'
D:/diego/bin/Boot2Docker/boot2docker.exe init
echo

echo 'starting...'
D:/diego/bin/Boot2Docker/boot2docker.exe start
echo

D:/diego/bin/Boot2Docker/boot2docker.exe ip

echo 'connecting...'
D:/diego/bin/Boot2Docker/boot2docker.exe ssh
echo

echo
echo '[Press any key to exit]'
read
