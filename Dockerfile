FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build target/onlineshop-1.jar /onlineshop/onlineshop-1.jar
CMD ["java","-jar","/onlineshop/onlineshop-1.jar"]