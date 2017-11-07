FROM redis:latest as builder

RUN set -ex;\
    apt-get update;\
    apt-get install -y --no-install-recommends wget unzip build-essential

ADD . /
WORKDIR /
RUN set -ex;\
    make all -j 4;

# Package the runner
FROM redis:latest
WORKDIR /data
RUN set -ex;\
    mkdir -p /var/lib/redis/modules/\
    chmod 777 /var/lib/redis/modules/
COPY /redis_date_module.so /var/lib/redis/modules/redis_date_module.so

CMD ["redis-server", "--loadmodule", "/var/lib/redis/modules/redis_date_module.so"]
