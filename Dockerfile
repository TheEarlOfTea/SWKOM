FROM eclipse-temurin:17-jdk-jammy
EXPOSE 8080
COPY /target/swagger-spring-1.0.0.jar ./swagger-spring-1.0.0.jar
CMD ["/usr/bin/java", "-jar", "/target/swagger-spring-1.0.0.jar"]
