# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="hedi.bahmed@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=target/hediapps-authentication-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} authetication.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/authetication.jar"]
