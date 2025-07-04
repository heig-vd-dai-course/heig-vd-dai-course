# whoami with host-based, path-based routing and `StripPrefix` middleware

This [whoami](https://github.com/traefik/whoami) example shows how to access the
whoami server with Traefik
[`PathPrefix`](https://doc.traefik.io/traefik/routing/routers/#rule) rule and
[`StripPrefix`](https://doc.traefik.io/traefik/middlewares/http/stripprefix/)
middleware locally with Docker and Docker Compose.

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

Open your browser and go to
`https://WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME/whoami-without-stripprefix` to
access whoami without the `StripPrefix` middleware.

Open your browser and go to
`https://WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME/whoami-with-stripprefix` to access
whoami with the `StripPrefix` middleware.
