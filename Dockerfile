FROM adoptopenjdk/openjdk11
CMD ["mvn", "-N", "io.takari:maven:wrapper"]
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=target/*.jar
COPY ${JAR_FILE_PATH} app.jar
EXPOSE 1234
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod" "app.jar"]
