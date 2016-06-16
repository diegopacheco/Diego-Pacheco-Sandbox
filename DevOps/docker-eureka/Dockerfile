FROM java:8
MAINTAINER Diego Pacheco - diego.pacheco.it@gmail.com

RUN apt-get update && \ 
    apt-get install -y \
	git \ 
	wget

WORKDIR /usr/local/

RUN rm -rf tomcat*

#RUN wget --no-check-certificate -O tomcat.tar.gz http://ftp.unicamp.br/pub/apache/tomcat/tomcat-7/v7.0.67/bin/apache-tomcat-7.0.67.tar.gz > /dev/null 2>&1
RUN wget --no-check-certificate -O tomcat.tar.gz http://mirrors.gigenet.com/apache/tomcat/tomcat-8/v8.0.35/bin/apache-tomcat-8.0.35.tar.gz > /dev/null 2>&1

RUN tar -xzvf tomcat.tar.gz
RUN rm -rf tomcat.tar.gz
RUN mv apache-tomcat-8.0.35/ tomcat8

RUN wget -O /usr/local/tomcat8/webapps/eureka.war -q http://central.maven.org/maven2/com/netflix/eureka/eureka-server/1.3.7/eureka-server-1.3.7.war

EXPOSE 8080
WORKDIR /usr/local/tomcat8
CMD ["bin/catalina.sh", "run"]

#
# to Build: $ docker docker build -t diegopacheco/eureka . 
# to Run  : $ docker run -d --net myDockerNetDynomite --ip 172.18.0.60 --name eureka diegopacheco/eureka
# to Enter: $ docker exec -it eureka bash
# 

#
# Check eureka Apps
#
# Run: curl -v http://172.18.0.60:8080/eureka/v2/apps | xmllint --format -
#

