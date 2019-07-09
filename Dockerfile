FROM openjdk:8
ADD target/mars-rover.jar mars-rover.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","mars-rover.jar"]

