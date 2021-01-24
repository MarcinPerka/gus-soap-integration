# gus-soap-integration
This is a project which use SOAP protocol to get data from GUS (https://api.stat.gov.pl/). The application shows use of the:
- Multi-stage Dockerfile to build and run app
- Integration with third party service using SOAP protocol
- Validation and binding request parameters to objects
- Exception handling using RestControllerAdvice
- Internationalization

## Live
- <a href="https://gus-soap-integration.herokuapp.com">GUS SOAP Integration</a>
- <a href="https://gus-soap-integration.herokuapp.com/gus/documentation/swagger-ui/">Docs</a>

## Technology stack
- Spring Boot
- Web Services
- Maven
- Docker
- Heroku

## Build app with docker
- Build `docker build . --tag gus-soap-integration`
- Run (set server port in docker container and bind it to host port eg. 8489) `docker run -p 8489:8489 -e "PORT=8489" gus-soap-integration`

## Swagger Paths
- All Swagger Resources(groups) `http://url:8489/gus/documentation/swagger-resources`
- Swagger UI endpoint: `http://url:8489/gus/documentation/swagger-ui/`
- Swagger docs endpoint: `http://url:8489/gus/v3/api-docs`

## TODO
- Add unit tests
- Add integration tests
- ResponseEntity -> Not found if all elements of dto are nulls etc.