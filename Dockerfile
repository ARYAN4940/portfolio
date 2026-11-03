# docker ek esa container hai jo apke application aur use chalane ke liye jaruri chijo ko ek package me rakhakar chalane me madad karta hai.  

FROM maven:3.9-eclipse-temurin-25 AS build     get a machine with Java + Maven
COPY pom.xml .                                 copy our library list
RUN mvn dependency:go-offline -B               download the libraries
COPY src ./src                                 copy our code
RUN mvn clean package -DskipTests -B           build the jar
FROM eclipse-temurin:21-jre                    now a SMALLER machine, Java only
COPY --from=build /app/target/*.jar app.jar    bring just the finished jar
ENTRYPOINT ["java", "-jar", "app.jar"]         run it