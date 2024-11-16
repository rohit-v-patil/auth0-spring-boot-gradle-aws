FROM amazoncorretto:8

WORKDIR /app
COPY *.jar auth0-test-app.jar
ENTRYPOINT ["java","-jar","/auth0-test-app.jar"]
