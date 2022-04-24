#!/bin/bash

if [ "$1" ]; then
  PROFILE="$1"
else
  echo "${0} PROFILE"
  exit 1
fi

echo "Docker Compose Profile: $PROFILE"

docker-compose --profile $PROFILE down

sudo rm -rf vol

mkdir -p vol/nifi/conf \
  vol/nifi/logs \
  vol/nifi/state \
  vol/nifi/content \
  vol/nifi/database \
  vol/nifi/flowfile \
  vol/nifi/provenance \
  vol/broker/zookeeper/data \
  vol/broker/zookeeper/log \
  vol/broker/kafka/data \
  vol/mysql \
  vol/postgres \
  vol/cubejs

docker-compose --profile $PROFILE up -d