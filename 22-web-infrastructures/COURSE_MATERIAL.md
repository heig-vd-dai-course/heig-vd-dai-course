[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/22-web-infrastructures/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/22-web-infrastructures/22-web-infrastructures-practical-work.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/122
[illustration]:
  https://images.unsplash.com/photo-1492515114975-b062d1a270ae?fit=crop&h=720

# Web infrastructures - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Prepare and setup your environment](#prepare-and-setup-your-environment)
  - [Access your `hosts` file](#access-your-hosts-file)
  - [Traefik](#traefik)
- [Web infrastructures: definition](#web-infrastructures-definition)
- [System scalability](#system-scalability)
  - [Vertical scaling](#vertical-scaling)
  - [Horizontal scaling](#horizontal-scaling)
- [HTTP features](#http-features)
  - [Simplicity / statelessness](#simplicity--statelessness)
  - [Scalability](#scalability)
  - [Reliability](#reliability)
  - [The `Host` header](#the-host-header)
- [Caching](#caching)
  - [Client-side caching](#client-side-caching)
  - [Server-side caching](#server-side-caching)
  - [CDN](#cdn)
  - [Expiration and validation](#expiration-and-validation)
- [Reverse-proxy](#reverse-proxy)
- [Load balancing](#load-balancing)
  - [Sticky sessions](#sticky-sessions)
  - [Round-robin](#round-robin)
  - [Other metrics](#other-metrics)
- [Practical content](#practical-content)
  - [Install and configure mkcert](#install-and-configure-mkcert)
  - [Start and configure a whoami container](#start-and-configure-a-whoami-container)
  - [Add and configure Traefik](#add-and-configure-traefik)
  - [Access the Traefik dashboard](#access-the-traefik-dashboard)
  - [Add a second whoami container](#add-a-second-whoami-container)
  - [Make usage of a reverse proxy with Traefik](#make-usage-of-a-reverse-proxy-with-traefik)
  - [Make usage of a load balancer with Traefik](#make-usage-of-a-load-balancer-with-traefik)
  - [Make usage of a health check with Traefik](#make-usage-of-a-health-check-with-traefik)
  - [Make usage of sticky sessions with Traefik](#make-usage-of-sticky-sessions-with-traefik)
  - [Make usage of a failover with Traefik](#make-usage-of-a-failover-with-traefik)
  - [Make usage of a HTTPS/TLS certificate with Traefik and mkcert](#make-usage-of-a-httpstls-certificate-with-traefik-and-mkcert)
  - [Horizontal scaling with Docker Compose](#horizontal-scaling-with-docker-compose)
  - [Load testing with Gatling](#load-testing-with-gatling)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

- TODO

## Prepare and setup your environment

### Access your `hosts` file

In this section, you will need to access your `hosts` file.

The host file is a computer file used by an operating system to map hostnames to
IP addresses. The hosts file is a plain text file and is conventionally named
`hosts`. The hosts file can be used as an alternative to (or in conjunction
with) DNS.

On Unix-like operating systems (Linux and macOS), the hosts file is located at
`/etc/hosts`.

On Windows, the hosts file is located at
`%SystemRoot%\system32\drivers\etc\hosts`.

Ensure you can access your `hosts` file and edit it for the next steps.

### Traefik

In this section, you will need to install and configure
[Traefik](https://traefik.io/traefik/) using its official Docker image available
on Docker Hub: <https://hub.docker.com/_/traefik>.

Traefik is an open-source Edge Router that makes publishing your services a fun
and easy experience. It receives requests on behalf of your system and finds out
which components are responsible for handling them.

Traefik is full of features and can be used as a reverse proxy, a load balancer,
a Kubernetes ingress controller, and much more.

We will go into more details about Traefik in the next sections.

Run the `traefik-insecure` example from the
[`heig-vd-dai-course/heig-vd-dai-course-code-examples`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-code-examples)
repository.

You should be able to access the Traefik dashboard at
<http://traefik.localhost>.

#### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Caddy](https://caddyserver.com/)
- [Nginx](https://www.nginx.com/)
- [HAProxy](https://www.haproxy.org/)

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Web infrastructures: definition

## System scalability

### Vertical scaling

### Horizontal scaling

## HTTP features

### Simplicity / statelessness

HTTP servers don’t have to store information

### Scalability

Several identical servers can handle requests without coordination

### Reliability

After a server failure, another server can easily take over the work

### The `Host` header

## Caching

### Client-side caching

### Server-side caching

### CDN

### Expiration and validation

## Reverse-proxy

## Load balancing

### Sticky sessions

### Round-robin

### Other metrics

- Least connections
- Least response time
- Hashing

## Practical content

### Install and configure mkcert

Follow the official documentation to install mkcert on your machine:
<https://github.com/FiloSottile/mkcert>.

Another good resource is the following article:
<https://web.dev/how-to-use-local-https/>.

### Start and configure a whoami container

### Add and configure Traefik

### Access the Traefik dashboard

### Add a second whoami container

### Make usage of a reverse proxy with Traefik

### Make usage of a load balancer with Traefik

### Make usage of a health check with Traefik

### Make usage of sticky sessions with Traefik

### Make usage of a failover with Traefik

### Make usage of a HTTPS/TLS certificate with Traefik and mkcert

### Horizontal scaling with Docker Compose

### Load testing with Gatling

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Are you able to add a basic authentication to the Traefik dashboard?

## Conclusion

### What did you do and learn?

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

You will start the practical work!

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Nicolas Picard](https://unsplash.com/@artnok) on
  [Unsplash](https://unsplash.com/photos/-lp8sTmF9HA)
