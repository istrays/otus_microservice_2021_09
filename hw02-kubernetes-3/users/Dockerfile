FROM openjdk:11-jdk-slim

WORKDIR /app/users

COPY build/libs/users-0.0.1-SNAPSHOT.jar /app/users/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","/app/users/app.jar"]