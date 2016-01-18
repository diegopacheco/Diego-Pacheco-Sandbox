FROM java:8
MAINTAINER Diego Pacheco - diego.pacheco.it@gmail.com

RUN apt-get update && apt-get install -y \
	autoconf \
	build-essential \
	dh-autoreconf \
	git \
	libssl-dev \
	libtool \
	python-software-properties \
	redis-server \
	tcl8.5 \
	dos2unix \ 
	unzip

RUN git clone https://github.com/Netflix/dynomite.git

ADD redis.conf /etc/redis/
ADD start.sh /usr/local/dynomite/
ADD provision-prana.sh /usr/local/dynomite/
ADD dynomite_prana.properties /usr/local/dynomite/
COPY redis_single.yml /dynomite/conf/redis_single.yml
COPY hosts /usr/local/dynomite/hosts

RUN chmod 777 /usr/local/dynomite/start.sh
RUN chmod 777 /usr/local/dynomite/provision-prana.sh

RUN /usr/local/dynomite/provision-prana.sh

WORKDIR /dynomite/

RUN autoreconf -fvi \
	&& ./configure --enable-debug=log \
	&& CFLAGS="-ggdb3 -O0" ./configure --enable-debug=full \
	&& make \
	&& make install

EXPOSE 8101
EXPOSE 6379
EXPOSE 22222
EXPOSE 8102

CMD ["/usr/local/dynomite/start.sh"]

#
# to Build: $ docker docker build -t diegopacheco/dynomite . 
# to Run  : $ docker run -P -d diegopacheco/dynomite
# to Enter: $ docker exec -it CONTAINER_ID bash
# 
