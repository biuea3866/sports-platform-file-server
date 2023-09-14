FROM adoptopenjdk/openjdk11
COPY build/libs/*.jar app.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/app.jar"]