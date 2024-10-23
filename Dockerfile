# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17-slim AS build

#ENV
ENV DB_HOST 127.0.0.1
ENV DB_PORT 5432
ENV DB_NAME api-market
ENV DB_SCHEMA zemsania
ENV DB_USER postgres
ENV DB_PASSWORD ftsuser420
ENV DB_SSL false

# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:11-jdk-slim
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*.jar app.jar

COPY api_market.sql /docker-entrypoint-initdb.d/
# Set the command to run the application
CMD ["java", "-jar", "app.jar"]