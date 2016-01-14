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
RUN echo 'Git repo has been cloned in your Docker VM'

ADD redis.conf /etc/redis/
ADD start.sh /usr/local/dynomite/
ADD provision-prana.sh /usr/local/dynomite/
ADD dynomite_prana.properties /usr/local/dynomite/

RUN chmod 777 /usr/local/dynomite/start.sh
RUN chmod 777 /usr/local/dynomite/provision-prana.sh
RUN dos2unix -k -o /usr/local/dynomite/start.sh	

RUN /usr/local/dynomite/provision-prana.sh

WORKDIR /dynomite/

RUN autoreconf -fvi \
	&& ./configure --enable-debug=log \
	&& CFLAGS="-ggdb3 -O0" ./configure --enable-debug=full \
	&& make \
	&& make install

RUN echo 'Exposing peer port 8101'
EXPOSE 8101

RUN echo 'Exposing Redis port 22221'
EXPOSE 22221

RUN echo 'Exposing stats/admin port 22222'
EXPOSE 22222

RUN echo 'Exposing client port for Dynomite 8102'
EXPOSE 8102

RUN echo 'Starting Dynomite'
ENTRYPOINT ["/usr/local/dynomite/start.sh"]