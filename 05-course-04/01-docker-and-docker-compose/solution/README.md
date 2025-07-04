# Docker and Docker Compose

_This solution depends on the previous
[Java IOs](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05-java-ios)
chapter._

This directory contains the solution to the
[Docker and Docker Compose](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06-docker-and-docker-compose)
practical content.

## Run the _"Go further"_ solution

You can specify the Docker Compose file to use with the `-f` option. This is
useful when you have multiple Docker Compose files in the same directory:

```sh
# Run the writer with the "docker-compose-with-environment-variables.yaml" file
docker compose -f docker-compose-with-environment-variables.yaml up writer

# Run the reader with the "docker-compose-with-environment-variables.yaml" file
docker compose -f docker-compose-with-environment-variables.yaml up reader
```
