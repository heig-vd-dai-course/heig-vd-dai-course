# Docker Compose with ports

This Docker Compose example shows how to expose ports from a container to the
host machine.

It uses [nginx](https://nginx.org/) with its official
[Docker image](https://hub.docker.com/_/nginx) as an example service.

nginx is a web server that can be used to serve static content or reverse proxy
to other services.

It uses a new key:

- `ports`

`ports` specifies the ports to expose from the container to the host machine. It
uses the format `HOST_PORT:CONTAINER_PORT`.

The `HOST_PORT` is the port on the host machine, and the `CONTAINER_PORT` is the
port on the container. Each container can have one or multiple ports exposed
that are used for various purposes, such as HTTP, HTTPS, SSH, or other services.

In this example, nginx lisens for incoming HTTP requests on port 80. We expose
port 8080 on the host machine to port 80 on the container. It means that the
nginx service will be accessible on <http://localhost:8080> from your host
machine.

## Run the Docker Compose

To run the Docker Compose, run the following command:

```sh
# Run the Docker Compose
docker compose up
```

The output should be similar to the following:

```text
[+] Running 8/8
 ✔ nginx Pulled                                                                                                                                                                                                                                                                   12.9s
   ✔ e4fff0779e6d Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 2a0cb278fd9f Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 7045d6c32ae2 Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 03de31afb035 Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 0f17be8dcff2 Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 14b7e5e8f394 Pull complete                                                                                                                                                                                                                                                   10.3s
   ✔ 23fa5a7b99a6 Pull complete                                                                                                                                                                                                                                                   10.3s
[+] Running 2/2
 ✔ Network 07-docker-compose-with-ports_default    Created                                                                                                                                                                                                                         0.2s
 ✔ Container 07-docker-compose-with-ports-nginx-1  Created                                                                                                                                                                                                                         0.9s
Attaching to nginx-1
nginx-1  | /docker-entrypoint.sh: /docker-entrypoint.d/ is not empty, will attempt to perform configuration
nginx-1  | /docker-entrypoint.sh: Looking for shell scripts in /docker-entrypoint.d/
nginx-1  | /docker-entrypoint.sh: Launching /docker-entrypoint.d/10-listen-on-ipv6-by-default.sh
nginx-1  | 10-listen-on-ipv6-by-default.sh: info: Getting the checksum of /etc/nginx/conf.d/default.conf
nginx-1  | 10-listen-on-ipv6-by-default.sh: info: Enabled listen on IPv6 in /etc/nginx/conf.d/default.conf
nginx-1  | /docker-entrypoint.sh: Sourcing /docker-entrypoint.d/15-local-resolvers.envsh
nginx-1  | /docker-entrypoint.sh: Launching /docker-entrypoint.d/20-envsubst-on-templates.sh
nginx-1  | /docker-entrypoint.sh: Launching /docker-entrypoint.d/30-tune-worker-processes.sh
nginx-1  | /docker-entrypoint.sh: Configuration complete; ready for start up
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: using the "epoll" event method
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: nginx/1.27.1
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: built by gcc 12.2.0 (Debian 12.2.0-14)
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: OS: Linux 6.10.4-200.fc40.x86_64
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: getrlimit(RLIMIT_NOFILE): 1073741816:1073741816
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker processes
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 29
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 30
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 31
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 32
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 33
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 34
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 35
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 36
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 37
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 38
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 39
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 40
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 41
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 42
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 43
nginx-1  | 2024/08/28 08:18:13 [notice] 1#1: start worker process 44
```

Docker Compose has started the nginx service under the name `nginx-1`. nginx is
started and listens for incoming HTTP requests on port 80.

You can access the nginx service from the host (= your current operating system)
in your web browser on <http://localhost:8080>.

The output should be similar to the following:

```text
Welcome to nginx!

If you see this page, the nginx web server is successfully installed and working. Further configuration is required.

For online documentation and support please refer to nginx.org.
Commercial support is available at nginx.com.

Thank you for using nginx.
```

## Stop the Docker Compose

To stop the Docker Compose, press `Ctrl+C` in the terminal where you ran the
`docker compose up` command.

The output should be similar to the following:

```text
Gracefully stopping... (press Ctrl+C again to force)
[+] Stopping 1/1
 ✔ Container 07-docker-compose-with-ports-nginx-1  Stopped                                                                                                                                                                                                                         0.2s
canceled
```

Docker Compose has stopped the nginx service.

## Start the Docker Compose in the background

To start the Docker Compose in the background, run the following command:

```sh
# Start the Docker Compose in the background
docker compose up -d
```

The `-d` flag (or `--detach`) runs the Docker Compose in detached mode. It means
that the Docker Compose runs in the background and does not block the terminal.

The output should be similar to the following:

```text
[+] Running 1/1
 ✔ Container 07-docker-compose-with-ports-nginx-1  Started
```

Docker Compose has started the nginx service in the background.

You can also start any Docker container in the background by using the `-d` flag
with the `docker run` command.

## Check the Docker Compose status

To check the status of the Docker Compose, run the following command:

```sh
# Check the Docker Compose status
docker compose ps
```

This will show the status of the services in the Docker Compose similar to the
following:

```text
NAME                                   IMAGE        COMMAND                  SERVICE   CREATED         STATUS         PORTS
07-docker-compose-with-ports-nginx-1   nginx:1.27   "/docker-entrypoint.…"   nginx     8 minutes ago   Up 4 minutes   0.0.0.0:8081->80/tcp, :::8080->80/tcp
```

While `docker compose ps` displays the status of the services, `docker ps` shows
the status of all running containers, even those not part of the Docker Compose.

Run the following command to check the status of all running containers:

```sh
# Check the status of all running containers
docker ps
```

## Check the outputs of the Docker Compose

To check the outputs of the Docker Compose, run the following command:

```sh
# Check the Docker Compose outputs
docker compose logs
```

Using the `docker compose logs` command without any arguments will show the
output of all services in the Docker Compose. The output should be similar to
the one you saw when you ran the Docker Compose in the foreground.

Using the `docker ps` command, you can see the container ID of the running
containers. You can then use the `docker logs` command to see the output of a
specific container.

```sh
# Check the output of a specific container
docker logs CONTAINER_ID
```

Replace `CONTAINER_ID` with the container ID you want to see the output of the
previous command.

## Access the nginx service

It is sometimes required to access the services running in the Docker Compose
from the host machine to check if they are working correctly.

To access the nginx service running in the Docker Compose, run the following
command:

```sh
# Access the nginx service
docker compose exec nginx /bin/bash
```

The `docker compose exec` command allows you to run commands inside a running
container. In this case, we run the `bash` command inside the `nginx` service
container.

Exit the container by running the following command:

```sh
# Exit the container
exit
```

You can also access the nginx service using the `docker exec` command:

```sh
# Access the nginx service using the docker exec command
docker exec -it CONTAINER_ID /bin/bash
```

Replace `CONTAINER_ID` with the container ID of the nginx service.

## Stop the Docker Compose in the background

To stop and remove the Docker Compose stack running in the background, i.e.
remove all the created resources: containers, networks, etc..., run the
following command:

```sh
# Stop and remove the Docker Compose stack running in the background
docker compose down
```

The output should be similar to the following:

```text
[+] Running 2/2
 ✔ Container 07-docker-compose-with-ports-nginx-1  Removed
 ✔ Network 07-docker-compose-with-ports_default    Removed
```
