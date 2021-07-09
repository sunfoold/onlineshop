FROM 031369846251.dkr.ecr.eu-central-1.amazonaws.com/openjdk11:alpine-jre
COPY target/onlineshop-1.jar /onlineshop/
CMD ["java","-jar","/onlineshop/onlineshop-1.jar"]