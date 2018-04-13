FROM ubuntu
USER root
RUN apt-get update;apt-get install -y openjdk-8-jdk-headless wget openssh-server tar vim

RUN apt-get install apache2 -y

#ssh
RUN echo "root:training" | chpasswd
RUN sed -i 's/prohibit-password/yes/' /etc/ssh/sshd_config
RUN mkdir /root/.ssh
RUN chown -R root:root /root/.ssh; chmod -R 700 /root/.ssh
RUN echo "StrictHostKeyChecking=no" >> /etc/ssh/ssh_config
RUN mkdir /var/run/sshd

#Startup
ADD start.sh /

EXPOSE 22 80
CMD bash /start.sh
