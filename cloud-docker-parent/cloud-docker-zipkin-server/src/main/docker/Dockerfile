FROM java:8
VOLUME /tmp
ADD cloud-docker-zipkin-server.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080