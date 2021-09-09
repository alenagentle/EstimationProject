FROM openjdk:11
EXPOSE 8080
WORKDIR /app
COPY . .
CMD ["java", "-jar", "/app/target/value-0.0.1-SNAPSHOT.jar"]
