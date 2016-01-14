FROM java:8
MAINTAINER Diego Pacheco - diego.pacheco.it@gmail.com

RUN apt-get update && \ 
    apt-get install -y \
	git \ 
	wget

WORKDIR /usr/local/

RUN rm -rf jetty*

RUN wget --no-check-certificate -O tomcat.tar.gz http://ftp.unicamp.br/pub/apache/tomcat/tomcat-7/v7.0.67/bin/apache-tomcat-7.0.67.tar.gz > /dev/null 2>&1

RUN tar -xzvf tomcat.tar.gz
RUN rm -rf tomcat.tar.gz
RUN mv apache-tomcat-7.0.67/ tomcat7

RUN wget -O /usr/local/tomcat7/webapps/eureka.war -q http://central.maven.org/maven2/com/netflix/eureka/eureka-server/1.3.7/eureka-server-1.3.7.war

EXPOSE 8080
WORKDIR /usr/local/tomcat7
CMD ["bin/catalina.sh", "run"]

#
# to Build: $ docker docker build -t diegopacheco/eureka . 
# to Run  : $ docker run -P -d diegopacheco/eureka
# to Enter: $ docker exec -it CONTAINER_ID bash
# 