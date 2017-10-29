FROM java:8
VOLUME /tmp
ADD cloud-docker-config.jar app.jar
ENV profile node1
ENTRYPOINT ["java","-Dspring.profiles.active=${profile}","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080