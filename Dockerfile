FROM openjdk:17
WORKDIR /app
COPY /application/target/application-0.0.1-SNAPSHOT.jar application.jar
CMD ["java", "-jar", "application.jar"]
