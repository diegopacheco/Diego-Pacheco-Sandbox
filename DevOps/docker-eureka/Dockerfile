FROM java:8
MAINTAINER Diego Pacheco - diego.pacheco.it@gmail.com

RUN apt-get update && \ 
    apt-get install -y \
	git \ 
	wget

WORKDIR /usr/local/

RUN rm -rf jetty*

RUN wget --no-check-certificate -O jetty.tar.gz http://eclipse.org/downloads/download.php?file=/jetty/9.3.3.v20150827/dist/jetty-distribution-9.3.3.v20150827.tar.gz > /dev/null 2>&1

RUN tar -xzvf jetty.tar.gz
RUN rm -rf jetty.tar.gz
RUN mv jetty-distribution-9.3.3.v20150827/ jetty9

RUN wget -O /usr/local/jetty9/webapps/eureka.war -q http://central.maven.org/maven2/com/netflix/eureka/eureka-server/1.3.7/eureka-server-1.3.7.war

EXPOSE 8080
WORKDIR /usr/local/jetty9
CMD ["java", "-jar", "/usr/local/jetty9/start.jar"]

#
# to Build: $ docker docker build -t diegopacheco/eureka . 
# to Run  : $ docker run -P diegopacheco/eureka
# to Enter: $ docker exec -it CONTAINER_ID bash
# 