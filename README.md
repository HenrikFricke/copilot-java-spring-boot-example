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