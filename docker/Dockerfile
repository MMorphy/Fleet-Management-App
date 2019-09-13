FROM centos/systemd

ENV JAVA_HOME=/usr/lib/jvm/jdk-11
ENV TOMCAT_HOME=/opt/tomcat
ENV PATH="/sbin:/bin:/usr/sbin:/usr/bin:/usr/lib/jvm/jdk-11/bin"
ENV container=docker

RUN yum -y upgrade
RUN yum -y install wget
RUN yum -y install epel-release
RUN yum -y install supervisor

# JVM install
RUN mkdir -p /usr/lib/jvm && \
wget https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz -O /tmp/openjdk-11+28_linux-x64_bin.tar.gz && \
	tar xfvz /tmp/openjdk-11+28_linux-x64_bin.tar.gz --directory /usr/lib/jvm && \
	rm -f /tmp/openjdk-11+28_linux-x64_bin.tar.gz

WORKDIR /tmp

# Tomcat install
RUN groupadd tomcat && \
    useradd -s /bin/false -g tomcat -d $TOMCAT_HOME tomcat && \
    mkdir -p $TOMCAT_HOME && \
    wget https://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.22/bin/apache-tomcat-9.0.22.tar.gz && \
    tar xzvf apache-tomcat-9.0.22.tar.gz -C $TOMCAT_HOME --strip-components=1 && \
    chown -R tomcat:tomcat $TOMCAT_HOME && \
    chmod -R g+r $TOMCAT_HOME/conf && \
    chmod g+x $TOMCAT_HOME/conf && \
    rm -rf apache-tomcat-9.0.22.tar.gz
	
# Tomcat and entripoint scripts
WORKDIR /
ADD start-tomcat.sh /start-tomcat.sh
ADD run.sh /run.sh
RUN chmod 755 /*.sh
ADD supervisord-tomcat.ini /etc/supervisord.d/supervisord-tomcat.ini

# MySQL install
RUN groupadd -g 77 -r mysql
RUN adduser mysql -u 77 -M -s /sbin/nologin -g mysql
RUN rpm -Uvh https://repo.mysql.com/mysql80-community-release-el7-3.noarch.rpm
RUN yum --enablerepo=mysql80-community -y install mysql-community-server



#MySQL scripts
ADD schema.sql /schema.sql
ADD data.sql /data.sql
ADD mysql-setup.sh /mysql-setup.sh
ADD create_mysql_user.sh /create_mysql_user.sh
ADD start-mysql.sh /start-mysql.sh
RUN chmod 755 *.sql
RUN chmod 755 *.sh
ADD supervisord-mysql.ini /etc/supervisord.d/supervisord-mysql.ini

#Application deploy
ADD FleetManagement-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/FleetManagement-0.0.1-SNAPSHOT.war

VOLUME  ["/var/lib/mysql"]

EXPOSE 8080

ENTRYPOINT ["/run.sh"]