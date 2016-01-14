#!/bin/bash

service redis-server start &

/usr/local/Prana/build/distributions/Prana-0.1.0-SNAPSHOT/bin/Prana -c /usr/local/dynomite/dynomite_prana.properties &

/dynomite/src/dynomite --conf-file=/dynomite/conf/redis_single.yml -v11 -o /dynomite/dynomite_log.txt