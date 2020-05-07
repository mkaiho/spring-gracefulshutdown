FROM openjdk:11-jdk-buster as builder
WORKDIR /home/work/spring-gracefulshutdown
COPY ./gradle /home/work/spring-gracefulshutdown/gradle
COPY ./gradlew /home/work/spring-gracefulshutdown
COPY ./settings.gradle /home/work/spring-gracefulshutdown
COPY ./build.gradle /home/work/spring-gracefulshutdown
COPY ./src /home/work/spring-gracefulshutdown/src
RUN ./gradlew clean build -x test

FROM openjdk:11-jre-buster
WORKDIR /home/spring-gracefulshutdown
COPY --from=builder \
/home/work/spring-gracefulshutdown/build/libs/spring-gracefulshutdown-0.0.1-SNAPSHOT.jar \
/home/spring-gracefulshutdown/build/libs/spring-gracefulshutdown-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "./build/libs/spring-gracefulshutdown-0.0.1-SNAPSHOT.jar"]
