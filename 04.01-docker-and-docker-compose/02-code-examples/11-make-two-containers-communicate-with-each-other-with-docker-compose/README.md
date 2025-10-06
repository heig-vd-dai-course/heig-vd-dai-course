# Make two containers communicate with each other with Docker Compose

This Docker Compose example shows how to use Docker networks to make two
containers communicate with each other.

## Build the Docker image

If you have not done already, build the Docker image from the previous example
in the `10-make-two-containers-communicate-with-each-other-with-docker`
directory.

## Run the Docker Compose services

Explore the `compose.yaml` file in this directory. Take some time to understand
what it does.

### Run the first service

Run the first service:

```sh
# Run the first service
docker compose run --rm ncat-server
```

This command runs the `ncat-server` Docker Compose service defined in the
`compose.yaml` file.

Once you have run the command, you should see no output. The container is now
listening for incoming connections on port `1234`.

### Run the second service

Run the second service:

```sh
# Run the second service
docker compose run --rm ncat-client
```

This command runs the `ncat-client` Docker Compose service defined in the
`compose.yaml` file.

Once you have run the command, you should see no output as well. However, if no
errors are displayed, the second container has connected to the first container.

Try typing some text in the second container. You should see the text appear in
the first container.

Both containers are now communicating with each other using the `ncat` tool.

To stop the containers, press `Ctrl+C` in each terminal.
