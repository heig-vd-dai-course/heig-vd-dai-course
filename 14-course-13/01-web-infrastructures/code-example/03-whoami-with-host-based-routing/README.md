# whoami with host-based routing

This [whoami](https://github.com/traefik/whoami) example shows how to access the
whoami server with Traefik
[`Host`](https://doc.traefik.io/traefik/routing/routers/#rule) rule on the
virtual machine with Docker and Docker Compose.

## Prerequisites

The [Traefik](../02-traefik) example must be running.

### Update the `.env` file

Update the [`.env`](.env) file with your own values:

- `WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME`: the fully qualified domain name to
  access whoami

Make sure that the fully qualified domain names are different and do not overlap
with the previous examples.

## Run the example

### Access the whoami dashboard

Start the containers on the virtual machine:

```sh
# Start the containers
docker compose up -d
```

Open your browser and go to the fully qualified domain name of the whoami
service you defined in the `.env` file with the `http` protocol, for example
`http://WHOAMI_FULLY_QUALIFIED_DOMAIN_NAME`.

You should notice that the request is automatically redirected to the `https`
protocol. This is because the Traefik container is configured to redirect all
requests to the `https` protocol.

Depending on the time it takes for the certificate to be generated, you might
see a warning about the certificate not being valid. If this happens, wait a few
minutes and refresh the page.

The page should now be secured with a valid certificate and a lock icon should
be displayed in the address bar.

You should now be able to access whoami with a valid HTTPS certificate.
