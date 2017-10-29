FROM java:8
VOLUME /tmp
ADD cloud-docker-user-service.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080