#!/bin/bash

sudo docker run --rm -v $(pwd):/bzt-configs undera/taurus *.yml
