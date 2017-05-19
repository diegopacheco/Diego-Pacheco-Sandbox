FROM java:8-jdk
MAINTAINER Diego Pacheco - diego.pacheco.it@gmail.com

RUN apt-get update && apt-get install -y unzip

RUN mkdir /app
ADD App.java /app

WORKDIR /app/

RUN wget http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/1.5.3.RELEASE/spring-boot-cli-1.5.3.RELEASE-bin.tar.gz -O /tmp/spring-boot-cli-1.5.3.RELEASE-bin.tar.gz \
    && tar -xzC /usr/lib/ -f /tmp/spring-boot-cli-1.5.3.RELEASE-bin.tar.gz \
    && rm /tmp/spring-boot-cli-1.5.3.RELEASE-bin.tar.gz \
    && sed -i "s|#!/usr/bin/env bash|#!/bin/sh|g" /usr/lib/spring-1.5.3.RELEASE/bin/spring \
    && ln -s /usr/lib/spring-1.5.3.RELEASE/bin/spring /usr/bin/spring \
    && spring --version

#ADD run-spring-boot.sh /app
#RUN chmod +x /app/run-spring-boot.sh

EXPOSE 8080

CMD ["spring","run","App.java"]

