 docker-compose exec postgres createdb --username=postgres ecom

 cat ecom-dump.sql | docker-compose exec -T postgres psql -U postgres -d ecom