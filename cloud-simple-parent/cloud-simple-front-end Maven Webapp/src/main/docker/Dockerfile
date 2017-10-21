FROM java:8
VOLUME /tmp
ADD cloud-simple-front-end.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
EXPOSE 8089