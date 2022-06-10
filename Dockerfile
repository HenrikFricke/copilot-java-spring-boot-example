FROM maven:3.8.5-openjdk-18-slim AS build

WORKDIR /build/

COPY ./pom.xml ./

# Each submodule pom has to be copied, else maven fails, even if that child module is not build
COPY apps/tutorials/pom.xml apps/tutorials/
COPY apps/events/pom.xml apps/events/


ARG APP
ENV APP ${APP}

RUN mvn -e -B --projects apps/${APP} dependency:go-offline

COPY . .

RUN mvn -Dmaven.test.skip=true --projects apps/${APP} package


FROM openjdk:18-jdk-oraclelinux8

ARG APP
ENV APP ${APP}

WORKDIR /app

COPY --from=build /build/apps/${APP}/target/${APP}-1.0.0.jar /app/app.jar

CMD ["java", "-jar",  "app.jar"]
