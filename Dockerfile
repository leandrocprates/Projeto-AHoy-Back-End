FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY target/*.jar /app/aplicacao-ahoy-back.jar
EXPOSE 8080
CMD java -XX:+UseContainerSupport  -Xmx512m  -jar aplicacao-ahoy-back.jar


# docker run -d --network=backend -e DB_HOST=mysql -p 8080:8080 lprates/aplicacao-ahoy-back



