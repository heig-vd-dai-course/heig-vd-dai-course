# Dockerfile with entrypoint and command

This Dockerfile example uses one new instruction:

- `ENTRYPOINT`

The `ENTRYPOINT` and `CMD` instructions are often confusing because they both
define what command to run when the container starts.

The main difference is that `ENTRYPOINT` is not overridden by passing a command
to the `docker run` command, a manual override is needed.

The `CMD` instruction is then passed as arguments to the `ENTRYPOINT`
instruction.

In this example, we use the `fedora:42` image. It means that the Docker image
will be based on the Fedora image and have all the tools and libraries provided
by this image, such as `bash` as the default shell and `dnf` to install new
packages.

## Build the Docker image

To build the Docker image, run the following command:

```sh
# Build the Docker image
docker build -t dockerfile-with-entrypoint-and-command .
```

## Run the Docker container

To run the Docker container, run the following command:

```sh
# Run the Docker container
docker run --rm dockerfile-with-entrypoint-and-command
```

The output should be similar to the following:

```text
Hello, World!
```

You can then override the default command by passing a command to the
`docker run` command:

```sh
# Run the Docker container with a custom command
docker run --rm dockerfile-with-entrypoint-and-command "Hello, DAI student!"
```

Notice how you did not have to pass the `echo` command as previous example? This
is thanks to the default command in the `ENTRYPOINT` instruction. New arguments
are simply appended to it.

To override the default command, you need to pass the `--entrypoint` flag to the
`docker run` command:

```sh
# Run the Docker container with a custom entrypoint
docker run --rm --entrypoint /bin/bash -it dockerfile-with-entrypoint-and-command
```

Other examples will help you understand the difference between `ENTRYPOINT` and
`CMD` in the next examples.

## Cleanup

To remove the Docker image, run the following command:

```sh
# Remove the Docker image
docker rmi dockerfile-with-entrypoint-and-command
```
