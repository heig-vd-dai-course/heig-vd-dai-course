# Docker Compose with volumes

The previous example showed how to use Docker Compose to start a nginx
container. When accessing the container on <http://localhost:8080>, it did
display the default nginx page.

This Docker Compose example uses a volume to share and persist files between the
host and the container. It is useful to share configuration files, logs, or data
between the host and the container.

It uses a new key:

- `volumes`

The `volumes` key specifies the volumes to mount in the container. It can be a
local directory or a named volume.

The current `html` directory is mounted to the `/usr/share/nginx/html` directory
in the container. It means that any file in the `html` directory will be
accessible in the container.

The `/usr/share/nginx/html` directory is the default directory where nginx
serves files.

The `html` directory contains an `index.html` file with a custom message.

## Run the Docker Compose

To run the Docker Compose, run the following command:

```sh
# Run the Docker Compose
docker compose up -d
```

Access the container on <http://localhost:8080> to see the custom message.

## Stop the Docker Compose

To stop and remove the Docker Compose stack, run the following command:

```sh
# Stop and remove the Docker Compose stack 
docker compose down
```