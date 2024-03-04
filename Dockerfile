FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/consultacnpj-0.0.1-SNAPSHOT.jar /app/consultacnpj.jar

ENTRYPOINT ["java", "-jar", "consultacnpj.jar"]
