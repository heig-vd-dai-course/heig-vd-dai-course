# Basic Dockerfile

This Dockerfile example uses two instructions:

- `FROM`
- `WORKDIR`

The `FROM` instruction specifies the base image to use for the build. In this
example, we use the `ubuntu:24.04` image. It means that the Docker image will be
based on the Ubuntu 24.04 image and have all the tools and libraries provided by
this image, such as `bash` as the default shell and `apt` to install new
packages.

The `WORKDIR` instruction sets the working directory for the rest of the
Dockerfile instructions.

It is equivalent to running `mkdir -p /path/to/workdir && cd /path/to/workdir`.

The default is often `/app`.

## Build the Docker image

To build the Docker image, run the following command:

```sh
# Build the Docker image
docker build -t basic-dockerfile .
```

## Run the Docker container

To run the Docker container, run the following command:

```sh
# Run the Docker container
docker run --rm -it basic-dockerfile /bin/bash
```

Run the following command to check the working directory:

```sh
# Check the working directory
pwd
```

The output should be similar to the following:

```text
/app
```

Exit the container by running the following command:

```sh
# Exit the container
exit
```

## Cleanup

To remove the Docker image, run the following command:

```sh
# Remove the Docker image
docker rmi basic-dockerfile
```
