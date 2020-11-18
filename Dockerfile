FROM openjdk:11-jre
WORKDIR D: /3 курс/ТРСПО/lab3/gateway/out/artifacts/gateway_jar
EXPOSE 8019
ENTRYPOINT ["java","-jar","/app.jar"]