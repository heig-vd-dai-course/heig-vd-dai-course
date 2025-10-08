# Docker Compose with environment variables

This Docker Compose example shows how to use environment variables in a Docker
Compose file.

Environment variables are often used to configure applications. They can be used
to define the application's behavior, such as the database connection string,
the log level, or the application's port.

It uses a new key:

- `environment`

Each container can have its own environment variables defined in the
`environment` section of the service definition.

The nginx container can use environment variables to configure the server's
port, the server's name, or the server's root directory.

Using a custom template file in the `templates` directory, the
`templates/default.conf.template` file is used to generate the
`/etc/nginx/conf.d/default.conf` file with the environment variables set in the
`compose.yaml` file as per the
[official nginx Docker image documentation](https://hub.docker.com/_/nginx).

This configuration changes the log files' location and loggers' level in the
`nginx.conf` file.

## Run the Docker Compose

To run the Docker Compose, run the following command:

```sh
# Run the Docker Compose
docker compose up -d
```

You should notice a new `logs` directory in the project directory. It contains
the `access.log` and `error.log` files.

Access the container on <http://localhost:8080> to see the default nginx page.

Access an invalid URL on <http://localhost:8080/invalid> to see the 404 error
page.

Check the `logs/error.log` file to see the error message. Notice how the log
displays all the `error` messages.

nginx uses several log levels, such as:

- `debug`
- `info`
- `notice`
- `warn`
- `error`
- `crit`
- `alert`
- `emerg`

As `error` messages might be too verbose (we might not be interested to see all
the invalid pages that are access from bots, users, etc. on our web server), you
can set the log level to `crit` to only display critical messages.

Stop the container and change the `NGINX_LOG_LEVEL` environment variable in the
`compose.yaml` file to `crit`.

Delete the `logs` directory with the following command to ensure that the logs
are updated:

```sh
# Delete the logs directory
sudo rm -rf logs
```

Run the Docker Compose again:

```sh
# Run the Docker Compose
docker compose up -d
```

Access an invalid URL on <http://localhost:8080/invalid> to see the 404 error
page.

Check the `logs/error.log` file to see the error message. Notice how the log
does not display the `error` messages anymore.

Environment variables can be used to configure the application's behavior
without changing the application's code.

## Stop the Docker Compose

To stop and remove the Docker Compose stack, run the following command:

```sh
# Stop and remove the Docker Compose stack
docker compose down
```
