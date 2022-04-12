#!/bin/bash

docker-compose down

rm -rf vol

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
  vol/mysql

docker-compose up -d