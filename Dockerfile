FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD arijboudhina/achat-1.0.jar achat-1.0.jar

ENTRYPOINT ["java","-jar","/achat-1.0.jar "]