# Copilot Java Spring Boot

## Prerequisites

- Docker
- AWS credentials for deployment
- [Copilot](https://aws.github.io/copilot-cli/)

## Usage

```sh
# Create .env file
cp .env.example .env

# Spin up server
docker-compose up
```

Go to http://localhost:8080. You should see a very basic HTML page.

In addition, you can use the REST API:

```sh
# Create tutorial
curl -X POST http://localhost:8080/api/tutorials --data '{"title": "Spring", "description": "WOW" }' -H "Content-Type: application/json"

# List tutorials
curl http://localhost:8080/api/tutorials
```

## Deployment

```sh
copilot deploy
```

## Ways to run this

The project setup supports different ways to start it.

### All in one

Since it is a multi-module maven spring-boot project you can just do

```bash
./mvnw spring-boot:run
```

and all modules will be run locally.
Make sure you have a local Postgres setup with correct users and tables (see module respective `application.yaml`)

### Seperated processes locally

If for some reason you only want to start one module, you can do this by leveraging the `--project` flag, e.g. for the
eureka service:

```bash
./mvnw --projects apps/eureka spring-boot:run
```

Same considerations as `All in one` apply.

### With docker-compose

We also support a fully dockerized environment, runnable via:

```bash
docker-compose up
```

This setup will take care of setting up a database for you.

### With copilot

TODO