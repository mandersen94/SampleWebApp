FROM tomcat:8.0-jre8

ADD ./target/SampleWebApp.war /usr/local/tomcat/webapps/SampleWebApp.war

EXPOSE 8080
CMD ["catalina.sh", "run"]