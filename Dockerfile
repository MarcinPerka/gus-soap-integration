FROM adoptopenjdk/openjdk11
VOLUME /tmp
EXPOSE 8489
COPY target/*.jar gus-soap-integration.jar
ENTRYPOINT ["java", "-jar","/gus-soap-integration.jar"]

