FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/onlineshop-1.jar /onlineshop/
CMD ["java","-jar","/onlineshop/onlineshop-1.jar"]