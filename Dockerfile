FROM maven:3.8.5-openjdk-18-slim AS build

COPY apps/tutorials/pom.xml /build/
COPY apps/tutorials/src /build/src/

WORKDIR /build/

RUN mvn -Dmaven.test.skip=true package -Ptest

FROM openjdk:18-jdk-oraclelinux8
EXPOSE 8080
WORKDIR /app

RUN microdnf install jq

COPY --from=build /build/target/demo-0.0.1-SNAPSHOT.jar /app/

CMD java -Dspring.datasource.url="jdbc:postgresql://$(echo $SPRINGCLUSTER_SECRET | jq -r '.host'):5432/$(echo $SPRINGCLUSTER_SECRET | jq -r '.dbname')" -Dspring.datasource.username="$(echo $SPRINGCLUSTER_SECRET | jq -r '.username')" -Dspring.datasource.password="$(echo $SPRINGCLUSTER_SECRET | jq -r '.password')" -jar demo-0.0.1-SNAPSHOT.jar
