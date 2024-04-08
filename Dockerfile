FROM openjdk:21-jdk
EXPOSE 8080
COPY target/finance_tracker-0.0.1-SNAPSHOT.jar /finance_tracker.jar
ENTRYPOINT ["java", "-jar", "/finance_tracker.jar"]