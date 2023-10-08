[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/10-docker-and-docker-compose/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-docker-and-docker-compose/10-docker-and-docker-compose-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/4
[illustration]:
  https://images.unsplash.com/photo-1511578194003-00c80e42dc9b?fit=crop&h=720

# Docker and Docker Compose - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Installation of software: traditional vs. containerization](#installation-of-software-traditional-vs-containerization)
- [OCI, images, containers and registries](#oci-images-containers-and-registries)
- [Docker](#docker)
  - [Dockerfile specification](#dockerfile-specification)
  - [Security considerations](#security-considerations)
  - [Summary](#summary)
  - [Cheatsheet](#cheatsheet)
  - [Alternatives](#alternatives)
  - [Resources](#resources)
- [Docker Compose](#docker-compose)
  - [Docker Compose specification](#docker-compose-specification)
  - [Summary](#summary-1)
  - [Alternatives](#alternatives-1)
  - [Resources](#resources-1)
- [Docker Desktop](#docker-desktop)
  - [Alternatives](#alternatives-2)
- [Docker Hub](#docker-hub)
  - [Alternatives](#alternatives-3)
- [Tips and tricks](#tips-and-tricks)
  - [Health checks](#health-checks)
  - [Free some space](#free-some-space)
  - [Multi-stage builds](#multi-stage-builds)
- [Practical content](#practical-content)
  - [Install Docker and Docker Compose](#install-docker-and-docker-compose)
  - [Run a container with Docker](#run-a-container-with-docker)
  - [Run a container with Docker Compose](#run-a-container-with-docker-compose)
  - [Write a Dockerfile, build and run an image with Docker](#write-a-dockerfile-build-and-run-an-image-with-docker)
  - [Build and run the same image with Docker Compose](#build-and-run-the-same-image-with-docker-compose)
  - [Publish an image on GitHub Container Registry](#publish-an-image-on-github-container-registry)
  - [Use the published image with Docker](#use-the-published-image-with-docker)
  - [Use the published image with Docker Compose](#use-the-published-image-with-docker-compose)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

In this chapter, you will learn how to use containerization to install and run
software on your computer with the help of Docker and Docker Compose.

## Installation of software: traditional vs. containerization

When you want to install a software on your computer, the traditional way is to
download an installer, run it and follow the instructions. The installer will
install the software on your computer, and you will be able to use it.

The installer has written some files on your computer, and it has modified some
settings. It can be quite difficult to know what the installer has done on your
computer. It can also be difficult to uninstall the software, because you need
to know what the installer has done. Even if the installer has an uninstaller,
it could not have removed everything.

The problem arises when you want to install another version of the software or
on another computer: if you install the new version, it will overwrite the old
version. If you want to keep the old version, you need to install the new
version in another directory. If you want to keep both versions, you need to
install the new version in another directory, and you need to change the
application's settings to use the new version. It becomes quite a mess.

If you want to install the software on another computer, you need to manually
change the settings; it can be difficult to know what to change.

Containerization solves these problems. With containerization, you can install
the software in a container. The container is a virtual environment that
contains the software and all its dependencies. The container is isolated from
the rest of the computer. The container can be run on any computer that has the
containerization software installed.

Each container is independent from the others. You can run multiple containers
on the same computer. You can run multiple containers of a software using
different versions, knowing that they will not interfere with each other.

Containers are lightweight. They are faster to start than virtual machines. They
are also faster to create and destroy than virtual machines.

The containerization software is called a container engine. The most popular
container engine is Docker. Docker is an implementation of the Open Container
Initiative (OCI) specification.

## OCI, images, containers and registries

The OCI specification defines a standard for container images and container
runtimes. The OCI specification is implemented by Docker, but also by other
container engines.

The OCI specification defines the following terms (among others):

- Image: a read-only template with instructions for creating a container
- Container: a runnable instance of an image
- Registry: a service that stores images

A container image is a package that contains everything needed to run an
application. It contains the application and all its dependencies. It also
contains metadata about the image, such as the author, the version, the
description, etc.

A container image is immutable. It cannot be modified. If you want to modify a
container image, you need to create a new image.

A container image is composed of layers. Each layer is a set of files. The
layers are stacked on top of each other. The layers are read-only. When you
modify a file, the file is copied to the top layer. The original file is not
modified.

A container image is stored in a container registry. A container registry is a
service that stores container images. The most popular container registry is
Docker Hub. It is a public registry. You can also create your own private
registry.

A container image can be downloaded from a container registry. It can also be
uploaded to a container registry.

A container image can be used to create a container. A container is a runnable
instance of an image. A container is created from an image. It is possible to
create multiple containers from the same image.

A container is isolated from the rest of the computer. It is isolated from other
containers.

## Docker

> [Docker](https://www.docker.com/) is a set of platform as a service (PaaS)
> products that use OS-level virtualization to deliver software in packages
> called containers.

Docker is composed of two parts:

- The Docker daemon: a background service that manages containers
- The Docker CLI: a command-line interface to interact with the Docker daemon

On Linux, the Docker daemon runs natively. The Docker CLI communicates with the
Docker daemon through a socket.

On macOS and Windows, the Docker daemon runs in a virtual machine. The Docker
CLI communicates with the Docker daemon through a socket.

The Docker CLI is used to manage containers. It is used to create, start, stop,
restart, delete, etc. containers. It is also used to manage images. It is used
to download, upload, build, etc. images.

### Dockerfile specification

The Dockerfile specification defines a standard for building Docker images. The
Dockerfile specification is implemented by Docker, but also by other container
engines.

The Dockerfile specification defines the following terms (among others):

- Dockerfile: a text file that contains instructions for building a Docker image
- Build context: a directory that contains the files needed to build a Docker

The Dockerfile specification defines a set of instructions. Each instruction
corresponds to a command that can be run in a shell. The instructions are
executed in order. Each instruction creates a new layer in the image.

The Dockerfile specification defines the following instructions (among others):

- `FROM`: specifies the base image
- `ARG`: specifies an argument to be passed to the build command
- `RUN`: runs a command in the container
- `COPY`: copies files from the build context to the container
- `CMD`: specifies the command to run when the container starts
- `ENTRYPOINT`: specifies the entry point of the container
- `ENV`: specifies an environment variable
- `EXPOSE`: specifies the port to expose
- `WORKDIR`: specifies the working directory
- `USER`: specifies the user
- `VOLUME`: specifies a volume

A Dockerfile is then used to build a Docker image. The Dockerfile is passed to
the `docker build` command. The `docker build` command builds the image from the
Dockerfile. The `docker build` command takes the Dockerfile and the build
context as arguments.

Once the image is built, it can be run with the `docker run` command. The
`docker run` command takes the image name as argument.

Most Docker images are based on Linux but others are available as well (Windows
for instance). It is possible to run Linux containers on Linux, macOS and
Windows (with the help of the Linux virtual machine).

### Security considerations

A container is isolated from the rest of the computer. It is isolated from other
containers. It is not isolated from the Docker daemon. The Docker daemon has
access to the container.

A container is not a virtual machine. It is not a sandbox. It is not a security
boundary. It is not a security boundary between the container and the Docker
daemon.

The Docker daemon runs with root privileges. You must be careful when running
containers. A security vulnerability in a container can lead to a full
compromise of the host. Always try to run containers with a non-root user.

It is not always possible to run a container with a non-root user. Some
containers require root privileges to run. Some containers requires access to
the Docker daemon. This is usually explicitly stated in the documentation of the
container.

### Summary

- Docker is a container engine
- Docker is composed of two parts: the Docker daemon and the Docker CLI
- The Docker CLI is used to manage containers and images
- The Dockerfile specification defines a standard for building Docker images
- A Dockerfile is used to build a Docker image
- A Docker image is used to create a container
- A container is a runnable instance of an image
- A container is isolated from the rest of the computer

### Cheatsheet

```sh
# Build and tag an image
docker build -t <image-name> <build-context>

# Start a container using its image name
docker run <image-name>

# Start a container in background
docker run -d <image-name>

# Display all running containers
docker ps

# Stop a container
docker stop <container-id>

# Access a running container
docker exec -it <container-id> /bin/sh

# Start a container and override the entry point
docker run --entrypoint /bin/sh <image-name>

# Start a container and override the command
docker run <image-name> <command>

# Delete all stopped containers
docker container prune

# Delete all images
docker image prune
```

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [podman](https://podman.io/)
- [containerd](https://containerd.io/)
- [LXC](https://linuxcontainers.org/lxc/introduction/)
- [Kubernetes](https://kubernetes.io/)
- [kaniko](https://github.com/GoogleContainerTools/kaniko)

_Missing item in the list? Feel free to open a pull request to add it! ✨_

### Resources

_Resources are here to help you. They are not mandatory to read._

- TODO

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Docker Compose

> [Docker Compose](https://docs.docker.com/compose/) is a tool for defining and
> running multi-container Docker applications.

Docker Compose is a tool that is used to run multiple containers. It is used to
run multiple containers that are related to each other. It is used to run
multiple containers that are part of the same application (a backend and its
database for example).

### Docker Compose specification

The Docker Compose specification defines a standard for defining and running
multi-container Docker applications. The Docker Compose specification is
implemented by Docker Compose, but also by other tools.

The Docker Compose specification defines the following terms (among others):

- Service: a container that is part of a multi-container Docker application
- Volume: a directory that is shared between the container and the host
- Network: a network that is shared between containers

### Summary

- TODO

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Docker Swarm](https://docs.docker.com/engine/swarm/)
- [Kubernetes](https://kubernetes.io/)

_Missing item in the list? Feel free to open a pull request to add it! ✨_

### Resources

_Resources are here to help you. They are not mandatory to read._

- TODO

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Docker Desktop

Docker Desktop is the easiest way to install Docker on your computer. It is
available for macOS and Windows. As a student, you can get use it for free.

Docker Desktop manages a Linux virtual machine. The Linux virtual machine runs
the Docker daemon.

As Docker Desktop uses a virtual machine, some configuration (mostly network)
might be a bit different than the one you can find on a Linux machine
(workstation or server).

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Rancher Desktop](https://rancherdesktop.io/)
- [OrbStack](https://orbstack.dev/) - for macOS only

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Docker Hub

> [Docker Hub](https://hub.docker.com) is the world's largest library and
> community for container images.

Docker Hub is a public container registry. It is the default registry for
Docker.

Other container registries are available. Some are public, some are private.

In this course, we will use the
[GitHub Container Registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-container-registry)
to store our images.

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [GitHub Container Registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-container-registry)

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Tips and tricks

### Health checks

Health checks are used to check if a container is healthy. They are used to
check if the container is ready to accept requests.

Health checks are defined in the Dockerfile. They are defined with the
`HEALTHCHECK` instruction.

The `HEALTHCHECK` instruction takes the following arguments:

- `--interval`: the interval between two health checks
- `--timeout`: the timeout of a health check
- `--start-period`: the time to wait before starting the health checks
- `--retries`: the number of retries before considering the container unhealthy
- `CMD`: the command to run to check the health of the container

For example, the following instruction defines a health check that runs every 30
seconds and that times out after 10 seconds:

```dockerfile
HEALTHCHECK --interval=30s --timeout=10s \
  CMD curl -f http://localhost/ || exit 1
```

If no health check is defined, Docker will use the default health check. The
default health check is to check if the container is running.

If no health check is defined, the container will be considered healthy as soon
as it is running. This is not always what you want. You might want to wait for
the container to be ready to accept requests.

You can define a health check that checks if the container is ready to accept in
the Docker Compose file. You can use the `healthcheck` option to define a health
check.

For example, the following option defines a health check that runs every 30
seconds and that times out after 10 seconds:

```yaml
healthcheck:
  test: ["CMD", "curl", "-f", "http://localhost/"]
  interval: 30s
  timeout: 10s
```

### Free some space

Docker images, containers and volumes can take a lot of space on your computer.

You can use the following commands to free some space:

```sh
# Delete all stopped containers, all networks not used by at least one container, all anonymous volumes not used by at least one container, all images without at least one container associated to them and all build cache
docker system prune --all --volumes
```

### Multi-stage builds

## Practical content

### Install Docker and Docker Compose

### Run a container with Docker

### Run a container with Docker Compose

### Write a Dockerfile, build and run an image with Docker

### Build and run the same image with Docker Compose

### Publish an image on GitHub Container Registry

### Use the published image with Docker

### Use the published image with Docker Compose

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Could you use Docker to run the application you have developed in the previous
  chapter? Add the required files and instructions to your repository!

## Conclusion

### What did you do and learn?

TODO

### Test your knowledge

At this point, you should be able to answer the following questions:

- TODO

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Java TCP programming

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [CHUTTERSNAP](https://unsplash.com/@chuttersnap) on
  [Unsplash](https://unsplash.com/photos/xewrfLD8emE)
