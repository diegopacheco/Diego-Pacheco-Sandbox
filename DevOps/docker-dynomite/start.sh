#!/bin/bash

service redis-server start &

nohup sh -c /dynomite/src/dynomite --conf-file=/dynomite/conf/redis_single.yml -v11 -o dynomite_log.txt