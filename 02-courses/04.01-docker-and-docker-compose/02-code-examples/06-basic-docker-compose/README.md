# Basic Docker Compose

This Docker Compose example uses one service, a simple hello-world service, that
prints a message to the console.

It uses two important keys:

- `services`
- `image`
- `command`

The `services` key specifies the services to run. In this example, we have only
two services called `hello-world` and `hello-dai-student`.

The `image` key specifies the image to use for a given service. It can be a
local image or a remote image from a registry like Docker Hub.

The `command` key specifies the command to run when the container starts. In
this example, we use the `echo` command to print a message to the console.

## Run the Docker Compose

To run the Docker Compose, run the following command:

```sh
# Run the Docker Compose
docker compose up
```

The output should be similar to the following:

```text
[+] Running 2/0
 ✔ Container 06-basic-docker-compose-hello-dai-student-1  Created          0.1s
 ✔ Container 06-basic-docker-compose-hello-world-1        Created          0.0s
Attaching to hello-dai-student-1, hello-world-1
hello-dai-student-1  | Hello, DAI student!
hello-world-1        | Hello, World!
hello-world-1 exited with code 0
hello-dai-student-1 exited with code 0
```

Each container has been created and run successfully. The `hello-world` service
prints `Hello, World!`, and the `hello-dai-student` service prints
`Hello, DAI student!`.

Once they have finished running, each container exits with code 0 (success).
