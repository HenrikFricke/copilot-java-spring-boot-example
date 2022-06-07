#!/bin/bash

export DB_HOST=$(echo ${!POSTGRES_CLUSTER_SECRET_NAME} | jq -r '.host')
export DB_USERNAME=$(echo ${!POSTGRES_CLUSTER_SECRET_NAME} | jq -r '.username')
export DB_PASSWORD=$(echo ${!POSTGRES_CLUSTER_SECRET_NAME} | jq -r '.password')

java -jar ${APP}-1.0.0.jar