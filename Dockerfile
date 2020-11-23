FROM adoptopenjdk/openjdk15
VOLUME /tmp
EXPOSE 8489
COPY target/*.jar gus-soap-integration.jar
ENTRYPOINT ["java", "-jar","/gus-soap-integration.jar"]

