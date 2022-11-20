FROM eclipse-temurin:17-jdk-jammy
EXPOSE 8080
COPY /home/runner/work/SWKOM/SWKOM/target/swagger-spring-1.0.0.jar ./swagger-spring-1.0.0.jar
ENV db-url $db-url
ENV db-username $db-username
ENV db-password $db-password
CMD ["java", "-jar", "./swagger-spring-1.0.0.jar"]
