# whoami with host-based and path-based routing

This [whoami](https://github.com/traefik/whoami) example shows how to access the
whoami server with Traefik
[`Host`](https://doc.traefik.io/traefik/routing/routers/#rule) and
[`PathPrefix`](https://doc.traefik.io/traefik/routing/routers/#rule) rules
locally with Docker and Docker Compose.

## Prerequisites

The [Traefik](../02-traefik) example must be running.

### Update the `.env` file

Update the [`.env`](.env) file with your own values:

- `WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME`: the fully qualified domain name to
  access whoami

Make sure that the fully qualified domain names are different and do not overlap
with the previous examples.

## Run the example

Start the containers:

```sh
# Start the containers
docker compose up
```

Open your browser and go to `https://WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME/whoami`
to access whoami.
