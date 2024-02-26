FROM openjdk:8
ADD target/stationSki-1.1.0.jar stationSki-1.1.0.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/stationSki-1.1.0.jar"]