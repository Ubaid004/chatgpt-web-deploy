

FROM openjdk:8-jre

WORKDIR /app

COPY  target/chatgpt-spring-boot.jar  app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
