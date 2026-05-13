#FROM maven:3.8.3-openjdk-17 AS build
#WORKDIR /app
#COPY src/main/java/org/example/bankingapplication /app/
#RUN mvn clean package
#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /app
#COPY --from=build /app/target/*.jar /app/app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]

FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]