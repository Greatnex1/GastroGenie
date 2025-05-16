FROM eclipse-temurin:17-alpine
MAINTAINER GastroGenie
EXPOSE 8086
ADD target/GastroGenie-0.0.1-SNAPSHOT.jar GastroGenie.jar
ENTRYPOINT ["java", "-jar", "/GastroGenie.jar"]