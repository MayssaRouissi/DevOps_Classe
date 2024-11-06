FROM openjdk:17-jdk

# Set environment variables
ENV NEXUS_URL="http://203.0.113.19:8081/repository/maven-releases/tn/esprit/tp-foyer/5.0.0/tp-foyer-5.0.0.jar"
ENV JAR_FILE="tp-foyer-5.0.0.jar"
ENV NEXUS_USERNAME="admin"
ENV NEXUS_PASSWORD="Wissem123456789*"

RUN curl -u $NEXUS_USERNAME:$NEXUS_PASSWORD -o $JAR_FILE $NEXUS_URL
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "tp-foyer-5.0.0.jar"]
