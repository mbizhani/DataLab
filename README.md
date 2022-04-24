# DataLab

TODO: `vol/nifi/conf` must be filled with NiFi conf before starting

```sh
# Call init.sh for following mkdir
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

docker-compose up -d
```

Web Apps

- [NiFi](https://localhost:8443/nifi)
- [UI for Kafka](http://localhost:8080)
- [Cube.js](http://localhost:4000)