#!/bin/bash

HOSTNAME=''
#HOSTNAME='127.0.0.1'

# if ! [ ! -z "$HOSTNAME" ]
if [ -z "$HOSTNAME" ]
then
    HOSTNAME="no-data"
fi

echo "Hostname is: $HOSTNAME"