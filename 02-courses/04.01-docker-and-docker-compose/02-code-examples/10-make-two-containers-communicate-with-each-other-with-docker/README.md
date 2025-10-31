# Make two containers communicate with each other with Docker

This Docker example shows how to use Docker networks to make two containers
communicate with each other.

## Build the Docker image

Explore the Dockerfile in this directory. Take some time to understand what it
does.

Build the Docker image with the following command:

```sh
# Build the Docker image
docker build -t ncat .
```

This will create a Docker image based on Ubuntu named `ncat` that contains the
`ncat` tool, a networking utility that reads and writes data across network
connections using the TCP or UDP protocol.

If you have not heard of `ncat` before, you will learn to use it the
[SMTP and ncat](../../../05.03-smtp-and-ncat/) course.

## Run the Docker container

Ensure you can run the `ncat` Docker image with the following command:

```sh
# Run the Docker container
docker run --rm -it ncat
```

It should display the `ncat` help message.

## Create a Docker network

Start by creating a Docker network that will be used by the two containers to
communicate with each other:

```sh
# Create a Docker network
docker network create heig-vd-dai
```

This command creates a Docker network named `heig-vd-dai`. The output displays
the network ID.

To list the Docker networks, run the following command:

```sh
# List the Docker networks
docker network ls
```

You should see the `heig-vd-dai` network in the list.

## Run the first container

Run the first container in the `heig-vd-dai` network:

```sh
# Run the first container
docker run --rm -it --network heig-vd-dai --name my-server ncat -l 1234
```

This command runs the `ncat` Docker image in the `heig-vd-dai` network with the
name `my-server` and listens for incoming connections on port `1234`.

The `--name` option is used to give the container a name. This is useful when
you want to refer to the container by name instead of its ID. It also sets the
hostname of the container to the name you specify, allowing you to use it in
place of the container's IP address.

Once you have run the command, you should see no output. The container is now
listening for incoming connections on port `1234`.

## Run the second container

Run the second container in the `heig-vd-dai` network:

```sh
# Run the second container
docker run --rm -it --network heig-vd-dai ncat my-server 1234
```

This command runs the `ncat` Docker image in the `heig-vd-dai` network and
connects to the `my-server` container on port `1234`.

Once you have run the command, you should see no output as well. However, if no
errors are displayed, the second container has connected to the first container.

Try typing some text in the second container. You should see the text appear in
the first container.

Both containers are now communicating with each other using the `ncat` tool.

To stop the containers, press `Ctrl+C` in each terminal.
