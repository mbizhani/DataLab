# DataLab

TODO: `vol/nifi/conf` must be filled with NiFi conf before starting

```sh
mkdir -p vol/nifi/conf \
  vol/nifi/logs \
  vol/nifi/state \
  vol/nifi/content \
  vol/nifi/database \
  vol/nifi/flowfile \
  vol/nifi/provenance

docker-compose up -d
```