# whoami with host-based routing and sticky sessions

This [whoami](https://github.com/traefik/whoami) example shows how to access the
whoami server with Traefik
[`Host`](https://doc.traefik.io/traefik/routing/routers/#rule) rule and
[sticky sessions](https://doc.traefik.io/traefik/routing/services/#sticky-sessions)
locally with Docker and Docker Compose.

## Prerequisites

The [Traefik](../02-traefik) example must be running.

Update the [`.env`](.env) file with your own values:

- `WHOAMI_1_FULLY_QUALIFIED_DOMAIN_NAME`: the fully qualified domain name to
  access the first whoami service
- `WHOAMI_2_FULLY_QUALIFIED_DOMAIN_NAME`: the fully qualified domain name to
  access the second whoami service

Make sure that the fully qualified domain names are different and do not overlap
with the previous examples.

## Run the example

Start the containers with 3 replicas of the `whoami-without-sticky-sessions`
service and 3 replicas of the `whoami-with-sticky-sessions` service:

```sh
# Start the containers
docker compose up --scale whoami-without-sticky-sessions=3 --scale whoami-with-sticky-sessions=3 -d
```

Open your browser and go to <https://WHOAMI_1_FULLY_QUALIFIED_DOMAIN_NAME> to
access whoami.

Refresh the page several times. You should notice the request being served by
different containers in a round-robin fashion (one request per container).

Access a new tab in your browser and go to
<https://WHOAMI_2_FULLY_QUALIFIED_DOMAIN_NAME> to access whoami.

Refresh the page several times. You should see the same container ID each time.

Open the developer tools of your browser and go to the "Application" or
"Storage" tab. You should see a cookie named `whoami` with its value.

If you delete the cookie, you will see a different container ID.

The cookie is sent to the server with each request. This is how Traefik knows
which container to send the request to.

You can try the same thing with a private window in your browser.
