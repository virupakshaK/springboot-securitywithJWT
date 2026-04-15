FROM openjdk:21-jdk-slim
WORKDIR /springboot-securitywithJWT
COPY target/*.jar springboot-securitywithJWT-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springboot-securitywithJWT-0.0.1-SNAPSHOT.jar"]