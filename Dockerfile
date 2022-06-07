FROM maven:3.8.5-openjdk-18-slim AS build

COPY . /build

WORKDIR /build/

ARG APP
ENV APP ${APP}

RUN mvn -Dmaven.test.skip=true --projects apps/${APP} package -Ptest

FROM openjdk:18-jdk-oraclelinux8

WORKDIR /app

ARG APP
ENV APP ${APP}

COPY --from=build /build/apps/${APP}/target/${APP}-1.0.0.jar /app/

CMD java -jar ${APP}-1.0.0.jar
