FROM public.ecr.aws/k7m1x2i5/11-jdk-slim:latest
COPY target/onlineshop-1.jar /onlineshop/
CMD ["java","-jar","/onlineshop/onlineshop-1.jar"]