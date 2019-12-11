FROM tomcat:jdk8-openjdk-slim

ADD target/reddit.cl.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
