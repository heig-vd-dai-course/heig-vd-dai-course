# Dockerfile with command

This Dockerfile example uses one new instruction:

- `CMD`

The `CMD` instruction specifies the default command to run when the container
starts. It can be overridden by passing a command to the `docker run` command.

In this example, we use the `debian:13` image. It means that the Docker image
will be based on the Debian image and have all the tools and libraries provided
by this image, such as `bash` as the default shell and `apt` to install new
packages.

## Build the Docker image

To build the Docker image, run the following command:

```sh
# Build the Docker image
docker build -t dockerfile-with-command .
```

## Run the Docker container

To run the Docker container, run the following command:

```sh
# Run the Docker container
docker run --rm dockerfile-with-command
```

The output should be similar to the following:

```text
Hello, World!
```

You can then override the default command by passing a command to the
`docker run` command:

```sh
# Run the Docker container with a custom command
docker run --rm dockerfile-with-command echo "Hello, DAI student!"
```

## Cleanup

To remove the Docker image, run the following command:

```sh
# Remove the Docker image
docker rmi dockerfile-with-command
```
