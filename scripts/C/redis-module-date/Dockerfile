FROM redis:latest as builder

ENV LIBDIR /var/lib/redis/modules

RUN set -ex;\
    apt-get update;\
    apt-get install -y --no-install-recommends wget unzip build-essential

ADD . /
WORKDIR /
RUN set -ex;\
    make all -j 4;

# Package the runner
FROM redis:latest
ENV LIBDIR /var/lib/redis/modules
WORKDIR /data
RUN set -ex;\
    mkdir -p "$LIBDIR";
COPY --from=builder /redis_date_module.so  "$LIBDIR"

CMD ["redis-server", "--loadmodule", "/var/lib/redis/modules/redis_date_module.so"]
