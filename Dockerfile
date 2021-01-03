FROM maven:3.6.3-adoptopenjdk-11 as build

COPY . /usr/src/gus-soap-integration

WORKDIR /usr/src/gus-soap-integration

RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S gus-soap-integration && adduser -S gus-soap-integration -G gus-soap-integration

RUN mkdir -p /files &&  \
        chown -R gus-soap-integration:gus-soap-integration /files

USER gus-soap-integration:gus-soap-integration

VOLUME /files

WORKDIR /app

COPY --from=build /usr/src/gus-soap-integration/target/*.jar /app/app.jar

EXPOSE 8489

ENTRYPOINT ["java", "-jar", "app.jar"]
