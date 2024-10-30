FROM openjdk:17-jdk-alpine
EXPOSE 8089

# Download the JAR from Nexus
RUN apk add --no-cache curl \
    && curl -o /tp-foyer-5.0.0.jar http://192.168.33.10:8081/repository/maven-releases/tn/esprit/tp-foyer/5.0.0/tp-foyer-5.0.0.jar

ENTRYPOINT ["java", "-jar", "/tp-foyer-5.0.0.jar"]
