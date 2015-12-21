#!/bin/bash
set -e

oe() { $@ 2>&1 | logger -t otto > /dev/null; }
ol() { echo "[otto] $@"; }

# Write the service file
ol "Configuring consul service: example"
cat <<DOC >/tmp/service.json
{
  "service": {
    "name": "example",
    "tags": [],
    "port": 0
  }
}
DOC
oe chmod 0644 /tmp/service.json
oe sudo mv /tmp/service.json /etc/consul.d/service.example.json

# Reload consul. It is okay if this fails.
oe consul reload
