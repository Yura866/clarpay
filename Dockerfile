FROM openjdk:8-alpine
 
# copy the packaged jar file into our docker image
COPY target/clearpay-0.0.1-SNAPSHOT.jar /clearpay.jar
 
# set the startup command to execute the jar
CMD ["java", "-jar", "/clearpay.jar"]