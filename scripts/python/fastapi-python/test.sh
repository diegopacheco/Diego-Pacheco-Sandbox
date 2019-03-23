#!/bin/bash

curl --silent http://127.0.0.1:8000/items/5?q=somequery | jq .
xdg-open http://127.0.0.1:8000/docs
